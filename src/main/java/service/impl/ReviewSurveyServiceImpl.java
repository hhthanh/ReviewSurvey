package service.impl;

import java.util.HashMap;
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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Student", getReviewSurveyDAO().getNumberByCriteria("jobstatus = 'Student'"));
		map.put("Employed", getReviewSurveyDAO().getNumberByCriteria("jobstatus = 'Employed'"));
		map.put("Unemployed", getReviewSurveyDAO().getNumberByCriteria("jobstatus = 'Unemployed'"));
		return map.entrySet();
	}

	public Set<Entry<Integer, Integer[]>> getReviewStaticByGender() {
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(1, new Integer[] { getReviewSurveyDAO().getNumberByCriteria("sex='m' AND rating_score=1"),
				getReviewSurveyDAO().getNumberByCriteria("sex='f' AND rating_score=1") });
		map.put(2, new Integer[] { getReviewSurveyDAO().getNumberByCriteria("sex = 'm' AND rating_score=2"),
				getReviewSurveyDAO().getNumberByCriteria("sex='f' AND rating_score=2") });
		map.put(3, new Integer[] { getReviewSurveyDAO().getNumberByCriteria("sex = 'm' AND rating_score=3"),
				getReviewSurveyDAO().getNumberByCriteria("sex='f' AND rating_score=3") });
		map.put(4, new Integer[] { getReviewSurveyDAO().getNumberByCriteria("sex = 'm' AND rating_score=4"),
				getReviewSurveyDAO().getNumberByCriteria("sex='f' AND rating_score=4") });
		map.put(5, new Integer[] { getReviewSurveyDAO().getNumberByCriteria("sex = 'm' AND rating_score=5"),
				getReviewSurveyDAO().getNumberByCriteria("sex='f' AND rating_score=5") });
		return map.entrySet();
	}

}
