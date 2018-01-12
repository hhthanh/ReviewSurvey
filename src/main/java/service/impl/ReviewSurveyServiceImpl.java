package service.impl;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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

	public Set<Entry<String, Integer>> getJobStatusChartData() {
		return getReviewSurveyDAO().getJobStatusChartData();
	}

	public Set<Entry<Integer, Integer[]>> getReviewStaticByGender() {
		return getReviewSurveyDAO().getReviewStaticByGender();
	}

	@Override
	public Set<Entry<String, Integer>> getNationalInfomation() {
		// TODO Auto-generated method stub
		return getReviewSurveyDAO().getNationalInfomation();
	}

	@Override
	public Set<Entry<String, Float>> getAverageRatingOverJob() {
		return getReviewSurveyDAO().getAverageRatingOverJob();
	}

	@Override
	public Set<Entry<String, Float>> getAverageRatingOverGender() {
		return getReviewSurveyDAO().getAverageRatingOverGender();
	}

}
