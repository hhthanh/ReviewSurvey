package dao;

import java.util.ArrayList;
import java.util.List;

import model.ReviewSurvey;

public interface ReviewSurveyDAO {
	public boolean addOrUpdateReviewSurveyToDB(ReviewSurvey rs);
	public List<ReviewSurvey> getAllReviewSurvey();
	public int getNumberByCriteria(String criteria);
	public int countField(String field);
	public int countFieldByCondition(String field, String condition);
	public ArrayList<?> getFieldListByCondition(String field, String condition);
	public ArrayList<?> getFieldList(String field);
}
