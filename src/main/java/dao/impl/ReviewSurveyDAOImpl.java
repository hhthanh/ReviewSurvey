package dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.ReviewSurveyDAO;
import model.ReviewSurvey;

public class ReviewSurveyDAOImpl extends JdbcDaoSupport implements ReviewSurveyDAO{

	//Add a review survey object to db
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs) {
		String sql = "INSERT INTO reviewsurvey ("
				+ "fullname, "
				+ "birthday, "
				+ "sex, "
				+ "country, "
				+ "jobstatus, "
				+ "rating_score, "
				+ "rating_content) "
				+ "VALUES (?,?,?,?,?,?,?)";
		//If there is no object map to the list, return false, esle return true
		if(getJdbcTemplate().update(sql, new Object[] {
				rs.getFullname(), 
				rs.getBirthday(),
				rs.getSex(),
				rs.getCountry(),
				rs.getJobStatus().toString(),
				rs.getRating_score(),
				rs.getRating_content()
		})!=1) return false;
		else return true;
	}
	
	public ArrayList<ReviewSurvey> getAllReviewSurvey() {
		String sql = "SELECT * FROM reviewsurvey";
		return (ArrayList<ReviewSurvey>) getJdbcTemplate().query(sql, new BeanPropertyRowMapper<ReviewSurvey>(ReviewSurvey.class));
	}
}
