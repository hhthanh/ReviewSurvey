package dao.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.ReviewSurveyDAO;
import model.Product;
import model.ReviewSurvey;

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
		String sql = "SELECT * FROM reviewsurvey WHERE " + criteria;
		return ((ArrayList<ReviewSurvey>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<ReviewSurvey>(ReviewSurvey.class))).size();
	}

	@Override
	public int countFieldByCondition(String field, String condition) {
		String sql = "SELECT count(?) FROM reviewsurvey WHERE " + condition;
		return getJdbcTemplate().queryForObject(sql, new Object[] { field }, Integer.class);

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
		String sql = "SELECT " + field + " FROM reviewsurvey WHERE " + condition + " GROUP BY " + field + " ORDER BY "
				+ field + " ASC";
		ArrayList<?> list = (ArrayList<?>) getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

	@Override
	public float getAverageRatingByCondition(String condition) {
		// TODO Auto-generated method stub
		String sql = "SELECT AVG(rating_score) FROM reviewsurvey WHERE " + condition;
		return getJdbcTemplate().queryForObject(sql, Float.class);
	}

}
