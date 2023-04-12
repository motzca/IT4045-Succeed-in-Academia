package com.succeedinacademia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.succeedinacademia.dao.IClassDAO;
import com.succeedinacademia.dao.ITaskDAO;
import com.succeedinacademia.dto.ClassDTO;
import com.succeedinacademia.dto.TaskDTO;

@Component
public class TaskService implements ITaskService {
	
	@Autowired
	IClassDAO classDAO;
	
	@Autowired
	ITaskDAO taskDAO;

	@Override
	public TaskDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(TaskDTO taskDTO) throws Exception {
		// TODO Auto-generated method stub
		taskDAO.save(taskDTO);
		return false;
	}
	
	@Override
	public Iterable<TaskDTO> fetchAllTasks() throws Exception {
		return taskDAO.fetchAll();
	}
	
	public void delete(int id) throws Exception {
		taskDAO.delete(id);
	}
	
	public void updateClass(TaskDTO taskDTO) throws Exception {
		taskDAO.save(taskDTO);
	}

}
