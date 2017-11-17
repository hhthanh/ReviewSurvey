package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ReviewSurveyDAO;
import service.ReviewSurveyService;

public class ReviewSurveyServiceImpl implements ReviewSurveyService {
	
	@Autowired
	private ReviewSurveyDAO reviewSurveyDAO;

	public ReviewSurveyDAO getReviewSurveyDAO() {
		return reviewSurveyDAO;
	}

	public void setReviewSurveyDAO(ReviewSurveyDAO reviewSurveyDAOImpl) {
		this.reviewSurveyDAO = reviewSurveyDAOImpl;
	}
	
	
}
