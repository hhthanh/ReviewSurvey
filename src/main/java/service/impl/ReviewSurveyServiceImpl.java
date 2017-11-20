package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ReviewSurveyDAO;
import model.ReviewSurvey;
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

	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs) {
		// TODO Auto-generated method stub
		return getReviewSurveyDAO().addOrUpdateReviewSurveyToDB(rs);
	}

	public List<ReviewSurvey> getAllReviewSurvey() {
		// TODO Auto-generated method stub
		return getReviewSurveyDAO().getAllReviewSurvey();
	}
	
	
}
