package com.succeedinacademia.service;

import com.succeedinacademia.dto.ClassDTO;
import com.succeedinacademia.dto.TaskDTO;

public class TaskServiceStub implements ITaskService {

	@Override
	public TaskDTO fetchById(int id) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setGuid(1);
		taskDTO.setItem("Final Project");
		
		ClassDTO classDTO = new ClassDTO();
		classDTO.setClassId(1);
		classDTO.setClassName("Enterprise App Development");
		
		taskDTO.setMyClass(classDTO);
		
		return taskDTO;
		
	}
	
	@Override
	public boolean save(TaskDTO taskDTO) throws Exception {
		return false;
		
	}

	@Override
	public Iterable<TaskDTO> fetchAllTasks() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateTask(TaskDTO taskDTO) throws Exception {
		return;
		
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return;
	}

}
