package service;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import model.ReviewSurvey;

public interface ReviewSurveyService {
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs);
	public List<ReviewSurvey> getAllReviewSurvey();
	public Set<Entry<String, Integer>> getJobStatusChartData();
	public Set<Entry<Integer, Integer[]>> getReviewStaticByGender();
	public Set<Entry<String, Integer>> getNationalInfomation();
}
