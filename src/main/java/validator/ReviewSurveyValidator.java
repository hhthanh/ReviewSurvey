package validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.ReviewSurvey;

public class ReviewSurveyValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ReviewSurvey.class.equals(arg0);
	}

	public void validate(Object reviewsurvey, Errors errors) {
		
		//Validate empty data
		
		
		ValidationUtils.rejectIfEmpty(errors, "birthday", "birthday.empty");
		ValidationUtils.rejectIfEmpty(errors, "jobStatus", "JobStatus.empty");
		ValidationUtils.rejectIfEmpty(errors, "country", "Country.empty");
		ValidationUtils.rejectIfEmpty(errors, "sex", "sex.empty");

		ReviewSurvey rs = (ReviewSurvey) reviewsurvey;
		if (rs.getRating_score() == null) {
			errors.rejectValue("rating_score", "score.empty");
		}

		//////// Validate each field in detail/////////

		// Validate fullname field

		// Validate name range
		if (rs.getFullname().length() > 50) {
			errors.rejectValue("fullname", "fullname.exceedMaxLength");
		}

		// Validate character range
		// 3000-303F : punctuation
		// 3040-309F : hiragana
		// 30A0-30FF : katakana
		// FF00-FFEF : Full-width roman + half-width katakana
		// 4E00-9FAF : Common and uncommon kanji
		String nameRegex = "[^ ]([\\u3000-\\u303F ]*|"
				+ "[\\u3040-\\u309F ]*|"
				+ "[\\u30A0-\\u30FF ]*|"
				+ "[\\uFF00-\\uFFEF ]*|"
				+ "[\\u4E00-\\u9FAF ]*|"
				+ "[a-zA-Z ]*)";
		if (!Pattern.matches(nameRegex, rs.getFullname())) {
			errors.rejectValue("fullname", "fullname.invalidCharacter");
		}else {
			ValidationUtils.rejectIfEmpty(errors, "fullname", "fullname.empty");
		}
		
		// Validate birthday
		
	}

}
