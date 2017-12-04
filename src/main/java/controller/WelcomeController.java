package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class WelcomeController {
	@RequestMapping(path="/")
	public ModelAndView method() {
        return new ModelAndView("redirect:" + "/review/survey");

}
	
	@RequestMapping("/404")
	public ModelAndView error404() {
		return new ModelAndView("error");
	}
}
