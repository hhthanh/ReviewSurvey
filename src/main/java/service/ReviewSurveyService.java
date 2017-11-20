package service;

import java.util.List;

import model.ReviewSurvey;

public interface ReviewSurveyService {
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs);
	public List<ReviewSurvey> getAllReviewSurvey();
}
