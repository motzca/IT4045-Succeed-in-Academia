package com.succeedinacademia;

import org.springframework.stereotype.Controller;

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
}
