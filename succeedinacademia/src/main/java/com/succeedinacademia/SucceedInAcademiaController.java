package com.succeedinacademia;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	private List<String> allClassNames;
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
		try {
			Iterable<ClassDTO> allClasses = classService.fetchAllClasses();
			model.addAttribute("allClasses", allClasses);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to retreive classes", e);
		}
		
		try {
			Iterable<TaskDTO> allTasks = taskService.fetchAllTasks();
			model.addAttribute("allTasks", allTasks);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to retreive tasks", e);
		}
		
		return "start";
	}
	
	@PostMapping(value="/saveclass")
	public String saveClass(ClassDTO classDTO) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			classService.save(classDTO);
		} catch (Exception e) {
			log.error("unable to save class", e);
			e.printStackTrace();
			modelAndView.setViewName("error");
			return "start";
		}
		
		modelAndView.addObject("classDTO", classDTO);
		
		allClassNames.add(classDTO.getClassName());
		
		return "start";
	}
	
	@PostMapping(value="/savetask")
	public String saveTask(TaskDTO taskDTO) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			taskService.save(taskDTO);
		} catch (Exception e) {
			log.error("unable to save class", e);
			e.printStackTrace();
			modelAndView.setViewName("error");
			return "start";
		}
		
		modelAndView.addObject("taskDTO", taskDTO);
		
		return "start";
	}
	
	@RequestMapping(value="/classesAutocomplete")
	@ResponseBody
	public List<String> classNamesAutocomplete(@RequestParam(value="term", required = false) String term) {
		List<String> suggestions = new ArrayList<String>();
		
		try {
			allClassNames = classService.fetchAllClassNames();
			for (String className : allClassNames) {
				suggestions.add(className);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			log.error("Exception in autocomplete", e);
		}
		
		return suggestions;
	}
	
	/*

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
	*/
}
