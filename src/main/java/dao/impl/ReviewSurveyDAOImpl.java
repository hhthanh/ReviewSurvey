package dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.ReviewSurveyDAO;
import model.Product;
import model.ReviewSurvey;
import util.JobStatus;

public class ReviewSurveyDAOImpl extends JdbcDaoSupport implements ReviewSurveyDAO {

	Logger logger = LogManager.getLogger(this.getClass());

	// Add a review survey object to db
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs) {
		try {
			HashMap<String, Object> rowMapper = new HashMap<String, Object>();
			rowMapper.put("fullname", rs.getFullname());
			rowMapper.put("birthday", rs.getBirthday());
			rowMapper.put("jobstatus", rs.getJobStatus());
			rowMapper.put("sex", rs.getSex());
			rowMapper.put("country", rs.getCountry());
			rowMapper.put("rating_score", rs.getRating_score());
			rowMapper.put("rating_content", rs.getRating_content());

			Integer survey_id = (new SimpleJdbcInsert(getJdbcTemplate()).withTableName("reviewsurvey").usingGeneratedKeyColumns("id"))
					.executeAndReturnKey(rowMapper).intValue();

			SimpleJdbcInsert insertSurveyProduct = new SimpleJdbcInsert(getJdbcTemplate())
					.withTableName("survey_product");

			for (Product p : rs.getProductList()) {
				Integer product_id = p.getId();
				HashMap<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("survey_id", survey_id);
				parameters.put("product_id", product_id);
				insertSurveyProduct.execute(parameters);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	public ArrayList<ReviewSurvey> getAllReviewSurvey() {
		
		String sql = "SELECT * FROM reviewsurvey";
		String sql2 = "SELECT p.id, p.name, p.description "
				+ "FROM survey_product sp INNER JOIN product p ON sp.product_id = p.id "
				+ "WHERE sp.survey_id = ?";

		logger.info("getAllReviewSurvey");
		try {
			ArrayList<ReviewSurvey> list = (ArrayList<ReviewSurvey>) getJdbcTemplate().query(sql,
					new BeanPropertyRowMapper<ReviewSurvey>(ReviewSurvey.class));
			for (ReviewSurvey rs : list) {
				rs.setProductList(getJdbcTemplate().query(sql2, new Object[] { rs.getId() },
						new BeanPropertyRowMapper<Product>(Product.class)));
				System.out.println(rs.getProductList().size());
			}
			logger.info("get " + list.size() + " survey");
			return list;
		} catch (Exception e) {
			logger.error("getAllReviewSurvey", e);
			return null;
		}

	}

	public int getNumberByCriteria(String criteria) {
		String sql = "SELECT * FROM reviewsurvey WHERE ?";
		return ((ArrayList<ReviewSurvey>) getJdbcTemplate().query(sql, new Object[] {criteria},
				new BeanPropertyRowMapper<ReviewSurvey>(ReviewSurvey.class))).size();
	}

	@Override
	public int countFieldByCondition(String field, String condition) {
		String sql = "SELECT count(?) FROM reviewsurvey WHERE ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { field, condition }, Integer.class);

	}

	@Override
	public ArrayList<?> getFieldList(String field) {
		return getFieldListByCondition(field, "1=1");
	}

	@Override
	public int countField(String field) {
		return countFieldByCondition(field, "1=1");
	}

	@Override
	public ArrayList<?> getFieldListByCondition(String field, String condition) {
		String sql = "SELECT ? FROM reviewsurvey WHERE ? GROUP BY ? ORDER BY "
				+ field + " ASC";
		ArrayList<?> list = (ArrayList<?>) getJdbcTemplate().queryForList(sql, new Object[] {field, condition, field, field} , String.class);
		return list;
	}

	@Override
	public float getAverageRatingByCondition(String condition) {
		// TODO Auto-generated method stub
		String sql = "SELECT AVG(rating_score) FROM reviewsurvey WHERE " + condition;
		return getJdbcTemplate().queryForObject(sql, Float.class);
	}

	@Override
	public Set<Entry<Integer, Integer[]>> getReviewStaticByGender() {
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(1, new Integer[] { getNumberByCriteria("sex='m' AND rating_score=1"),
				getNumberByCriteria("sex='f' AND rating_score=1") });
		map.put(2, new Integer[] { getNumberByCriteria("sex = 'm' AND rating_score=2"),
				getNumberByCriteria("sex='f' AND rating_score=2") });
		map.put(3, new Integer[] {getNumberByCriteria("sex = 'm' AND rating_score=3"),
				getNumberByCriteria("sex='f' AND rating_score=3") });
		map.put(4, new Integer[] {getNumberByCriteria("sex = 'm' AND rating_score=4"),
				getNumberByCriteria("sex='f' AND rating_score=4") });
		map.put(5, new Integer[] { getNumberByCriteria("sex = 'm' AND rating_score=5"),
				getNumberByCriteria("sex='f' AND rating_score=5") });
		return map.entrySet();
	}

	@Override
	public Set<Entry<String, Integer>> getJobStatusChartData() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Student", getNumberByCriteria("jobstatus = 'Student'"));
		map.put("Employed", getNumberByCriteria("jobstatus = 'Employed'"));
		map.put("Unemployed", getNumberByCriteria("jobstatus = 'Unemployed'"));
		return map.entrySet();
	}

	@Override
	public Set<Entry<String, Integer>> getNationalInfomation() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		@SuppressWarnings("unchecked")
		List<String> countryList = (List<String>) getFieldList("country");
		for(String s : countryList) {
			map.put(s, countFieldByCondition("country", "country='"+s+"'"));
		}
		return map.entrySet();
	}

	@Override
	public Set<Entry<String, Float>> getAverageRatingOverJob() {
		// TODO Auto-generated method stub
		HashMap<String, Float> map = new HashMap<String, Float>();
		for(JobStatus j : JobStatus.values()) {
			map.put(j.toString(), getAverageRatingByCondition("jobStatus = '"+j.toString()+"'"));
		}
		return map.entrySet();
	}

	@Override
	public Set<Entry<String, Float>> getAverageRatingOverGender() {
		// TODO Auto-generated method stub
		HashMap<String, Float> map = new HashMap<String, Float>();
		map.put("Male", getAverageRatingByCondition("sex = 'm'"));
		map.put("Female", getAverageRatingByCondition("sex = 'f'"));
		return map.entrySet();
	}

}
