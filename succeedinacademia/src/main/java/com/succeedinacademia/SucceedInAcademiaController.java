package com.succeedinacademia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.succeedinacademia.dto.TaskDTO;

@Controller
public class SucceedInAcademiaController {
	
	@RequestMapping(value="/savetask")
	public String saveTask(TaskDTO taskDTO) {
		taskDTO.setGuid(13);
		return "start";
	}
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
		model.addAttribute("taskDTO", new TaskDTO());
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
