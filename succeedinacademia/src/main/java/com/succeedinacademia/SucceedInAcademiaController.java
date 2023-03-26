package com.succeedinacademia;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.succeedinacademia.dto.TaskDTO;
import com.succeedinacademia.dto.ClassDTO;
import com.succeedinacademia.service.IClassService;
import com.succeedinacademia.service.ITaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SucceedInAcademiaController {
		
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IClassService classService;
	
	@Autowired
	private ITaskService taskService;
	
	private List<ClassDTO> allClasses;
	
	private List<TaskDTO> allTasks;
	
	/*
	@RequestMapping(value="/savetask")
	public String saveTask(TaskDTO taskDTO) {
		taskDTO.setGuid(13);
		return "start";
	}*/
	
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
	
	@RequestMapping("/showClasses")
	public ModelAndView showClasses() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Iterable<ClassDTO> allClasses = classService.fetchAllClasses();
			modelAndView.setViewName("showClasses");
			modelAndView.addObject("allClasses", allClasses);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to retreive classes", e);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
	@RequestMapping("/showTasks")
	public ModelAndView showTasks() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Iterable<TaskDTO> allTasks = taskService.fetchAllTasks();
			modelAndView.setViewName("showTasks");
			modelAndView.addObject("allTasks", allTasks);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to retreive tasks", e);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
}
