package dao;

import java.util.List;

import model.ReviewSurvey;

public interface ReviewSurveyDAO {
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs);
	public List<ReviewSurvey> getAllReviewSurvey();
	public int getNumberByCriteria(String criteria);
}
