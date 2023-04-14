package com.succeedinacademia;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// Gets all classes
	@RequestMapping(value="/classes", method=RequestMethod.GET)
	public String classes(Model model) {
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
		
		return "classes";
	}
	
	//Gets a single class
	@GetMapping(value="/classes/{id}")
		public ClassDTO fetchById(@PathVariable("id") int id) throws Exception {
			return classService.fetchById(id);
		}

	
	@PostMapping(value="/saveclass")
	public ModelAndView saveClass(ClassDTO classDTO) {
	    ModelAndView modelAndView = new ModelAndView();
	    try {
	        classService.save(classDTO);
	    } catch (Exception e) {
	        log.error("unable to save class", e);
	        e.printStackTrace();
	        modelAndView.setViewName("error");
	        return modelAndView;
	    }

	    modelAndView.setViewName("redirect:/classes");

	    //allClassNames.add(classDTO.getClassName());

	    return modelAndView;
	}

	
	// Saves tasks
	@PostMapping(value="/savetask")
	public ModelAndView saveTask(TaskDTO taskDTO) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			taskService.save(taskDTO);
		} catch (Exception e) {
			log.error("unable to save class", e);
			e.printStackTrace();
			modelAndView.setViewName("error");
			return modelAndView;
		}
		
		modelAndView.setViewName("redirect:/start");
		
		modelAndView.addObject("taskDTO", taskDTO);
		
		return modelAndView;
	}
	
	// Deletes Class
	@PostMapping("/classes/delete")
	public String deleteClass(@ModelAttribute("class") ClassDTO classDTO) throws Exception {
	    classService.delete(classDTO.getClassId());
	    return "redirect:/classes";
	}
	
	@PostMapping("/classes/edit/{classId}")
	public String editClass(@PathVariable Integer classId, @ModelAttribute("classDTO") ClassDTO classDTO) throws Exception {
	    classDTO.setClassId(classId);
	    classService.updateClass(classDTO);
	    return "redirect:/classes";
	}
	
	@DeleteMapping("/tasks/{id}")
	  public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
	    try {
	      taskService.delete(id);
	      return ResponseEntity.noContent().build();
	    } catch (Exception e) {
	      e.printStackTrace();
	      log.error("Unable to delete task", e);
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
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
	
}
