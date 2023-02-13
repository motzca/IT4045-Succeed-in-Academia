package com.succeedinacademia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SucceedInAcademiaController {
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String start() {
		return "start";
	}
	
	/**
	 * Handle the / endpoint
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "start";
	}
}
