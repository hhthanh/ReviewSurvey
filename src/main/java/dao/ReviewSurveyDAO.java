package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import model.ReviewSurvey;

public interface ReviewSurveyDAO {
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs);
	public List<ReviewSurvey> getAllReviewSurvey();
	public int getNumberByCriteria(String criteria);
	public int countField(String field);
	public int countFieldByCondition(String field, String condition);
	public ArrayList<?> getFieldListByCondition(String field, String condition);
	public ArrayList<?> getFieldList(String field);
	public float getAverageRatingByCondition(String condition);
	public Set<Entry<Integer, Integer[]>> getReviewStaticByGender();
	public Set<Entry<String, Integer>> getJobStatusChartData();
	public Set<Entry<String, Integer>> getNationalInfomation();
	public Set<Entry<String, Float>> getAverageRatingOverJob();
	public Set<Entry<String, Float>> getAverageRatingOverGender();
}
