package com.succeedinacademia.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.TaskDTO;

@Component
public class TaskDAO implements ITaskDAO {
	Map<Integer, TaskDTO> allTasks = new HashMap<>();
	@Autowired
	TaskRepository taskRepository;

	@Override
	public boolean save(TaskDTO taskDTO) throws Exception {
		// TODO Auto-generated method stub
		taskRepository.save(taskDTO);
		return false;
	}

	@Override
	public Iterable<TaskDTO> fetchAll() throws Exception {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public List<TaskDTO> fetchTasksByClassId(int classId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(int id) {
		allTasks.remove(id);
		taskRepository.deleteById(id);
	}


}
