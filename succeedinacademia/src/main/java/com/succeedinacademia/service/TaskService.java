package com.succeedinacademia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.succeedinacademia.dao.IClassDAO;
import com.succeedinacademia.dao.ITaskDAO;
import com.succeedinacademia.dto.TaskDTO;

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

}