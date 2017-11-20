package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.ReviewSurvey;

public class ReviewSurveyValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ReviewSurvey.class.equals(arg0);
	}

	public void validate(Object reviewsurvey, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "fullname", "fullname.empty");
		ValidationUtils.rejectIfEmpty(errors, "birthday", "birthday.empty");
		ValidationUtils.rejectIfEmpty(errors, "jobStatus", "jobStatus.empty");
		ValidationUtils.rejectIfEmpty(errors, "country", "country.empty");
		ValidationUtils.rejectIfEmpty(errors, "sex", "sex.empty");
		
		ReviewSurvey rs = (ReviewSurvey) reviewsurvey;
		if(rs.getRating_score()==null) {
			errors.rejectValue("rating_score", "score.empty");
		}
	}

}
