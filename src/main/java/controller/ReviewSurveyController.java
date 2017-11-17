package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.ReviewSurvey;

@Controller
@RequestMapping("/review")
public class ReviewSurveyController {
	
	@GetMapping(path="survey")
	public ModelAndView getSurveyPage() {
		return new ModelAndView("reviewSurvey").addObject("reviewSurvey", new ReviewSurvey());
	}

	@PostMapping("survey")
	public ModelAndView postSurveyPage(@ModelAttribute ReviewSurvey reviewSurvey, BindingResult bindingResult,
			ModelAndView mw) {
		
		if(bindingResult.hasErrors()) {
			mw.setViewName("reviewSurvey");
		}
		else {
			mw.setViewName("thank");
		}
		return mw;
	}
}
