package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.ReviewSurvey;
import service.ReviewSurveyService;
import validator.ReviewSurveyValidator;

@Controller
@RequestMapping("/review")
public class ReviewSurveyController {

	@Autowired
	private ReviewSurveyService reviewSurveyService;
	
	@GetMapping(path="index")
	public ModelAndView getIndexPage() {
		ModelAndView mw = new ModelAndView("reviewIndex");
		mw.addObject("surveylist", reviewSurveyService.getAllReviewSurvey());
		return mw;
	}
	
	@GetMapping(path = "survey")
	public ModelAndView getSurveyPage() {
		return new ModelAndView("reviewSurvey").addObject("reviewSurvey", new ReviewSurvey());
	}

	@PostMapping("survey")
	public ModelAndView postSurveyPage(@ModelAttribute ReviewSurvey reviewSurvey, BindingResult bindingResult,
			ModelAndView mw) {

		ReviewSurveyValidator validator = new ReviewSurveyValidator();
		validator.validate(reviewSurvey, bindingResult);

		if (bindingResult.hasErrors()) {
			System.out.println("Error!");
			mw.setViewName("reviewSurvey");
		} else {

			if (reviewSurveyService.addOrUpdateReviewSurveyToDB(reviewSurvey)) mw.setViewName("thank");
			else mw.setViewName("error");
		}
		return mw;
	}
}
