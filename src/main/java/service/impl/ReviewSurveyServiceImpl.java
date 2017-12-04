package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ReviewSurveyDAO;
import model.ReviewSurvey;
import service.ReviewSurveyService;
import util.Job;

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

	@Override
	public Set<Entry<String, Integer>> getNationalInfomation() {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		@SuppressWarnings("unchecked")
		List<String> countryList = (List<String>) getReviewSurveyDAO().getFieldList("country");
		for(String s : countryList) {
			map.put(s, getReviewSurveyDAO().countFieldByCondition("country", "country='"+s+"'"));
		}
		return map.entrySet();
	}

	@Override
	public Set<Entry<String, Float>> getAverageRatingOverJob() {
		// TODO Auto-generated method stub
		HashMap<String, Float> map = new HashMap<String, Float>();
		for(Job j : Job.values()) {
			map.put(j.toString(), getReviewSurveyDAO().getAverageRatingByCondition("jobStatus = '"+j.toString()+"'"));
		}
		map.entrySet().forEach(e->System.out.println(e.getKey()+e.getValue()));
		return map.entrySet();
	}

	@Override
	public Set<Entry<String, Float>> getAverageRatingOverGender() {
		// TODO Auto-generated method stub
		HashMap<String, Float> map = new HashMap<String, Float>();
		map.put("Male", getReviewSurveyDAO().getAverageRatingByCondition("sex = 'm'"));
		map.put("Female", getReviewSurveyDAO().getAverageRatingByCondition("sex = 'f'"));
		return map.entrySet();
	}

}
