package controller;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import model.ReviewSurvey;
import service.ReviewSurveyService;
import util.Country;
import util.JobStatus;
import util.LanguageHelper;
import validator.ReviewSurveyValidator;

@Controller
@RequestMapping("/review")
public class ReviewSurveyController {

	@Autowired
	private ReviewSurveyService reviewSurveyService;
	@Autowired
	private LanguageHelper helper;
	
	@GetMapping(path="index")
	public ModelAndView getIndexPage() {
		ModelAndView mw = new ModelAndView("reviewIndex");
		mw.addObject("surveylist", reviewSurveyService.getAllReviewSurvey());
		return mw;
	}
	
	@GetMapping(path="analyze")
	public ModelAndView getAnlyzePage() {
		ModelAndView mw = new ModelAndView("reviewAnalyze");
		try{
		mw.addObject("piechartJobData",reviewSurveyService.getJobStatusChartData());
		mw.addObject("barChartGenderData", reviewSurveyService.getReviewStaticByGender());
		mw.addObject("piechartAveragePointJobData", reviewSurveyService.getAverageRatingOverJob());
		mw.addObject("piechartAveragePointGenderData", reviewSurveyService.getAverageRatingOverGender());
		return mw;
		}catch(NullPointerException e){
			return new ModelAndView("error");
		}
		
	}
	
	@GetMapping(path = "survey")
	public ModelAndView getSurveyPage(HttpServletRequest request) {
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		HashMap<String, String> mapJobStatus = helper.getLocalLanguageName(JobStatus.class,locale);
		HashMap<String, String> mapCountry = helper.getLocalLanguageName(Country.class,locale);
		return new ModelAndView("reviewSurvey")
				.addObject("reviewSurvey", new ReviewSurvey())
				.addObject("jobStatusList", mapJobStatus.entrySet())
				.addObject("countryList", mapCountry.entrySet());
	}

	@PostMapping("survey")
	public ModelAndView postSurveyPage(@ModelAttribute ReviewSurvey reviewSurvey, BindingResult bindingResult,
			ModelAndView mw, HttpServletRequest request) {

		ReviewSurveyValidator validator = new ReviewSurveyValidator();
		validator.validate(reviewSurvey, bindingResult);

		if (bindingResult.hasErrors()) {
			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
			HashMap<String, String> mapJobStatus = helper.getLocalLanguageName(JobStatus.class,locale);
			HashMap<String, String> mapCountry = helper.getLocalLanguageName(Country.class,locale);
			mw.addObject("jobStatusList", mapJobStatus.entrySet())
			.addObject("countryList", mapCountry.entrySet())
			.addObject("reviewSurvey",reviewSurvey)
			.setViewName("reviewSurvey");
		} else {

			if (reviewSurveyService.addOrUpdateReviewSurveyToDB(reviewSurvey)) mw.setViewName("thank");
			else mw.setViewName("error");
		}
		return mw;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleResourceNotFoundException() {
        return new ModelAndView("error");
    }
}
