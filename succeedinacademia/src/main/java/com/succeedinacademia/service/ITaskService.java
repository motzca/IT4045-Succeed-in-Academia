package com.succeedinacademia.service;

import com.succeedinacademia.dto.TaskDTO;

public interface ITaskService {
	
	/**
	 * Get tasks from persistence layer.
	 * @param id a unique lookup.
	 * @return a task with a matching ID. 
	 */
	TaskDTO fetchById(int id);
	
	/**
	 * Persist the given DTO.
	 * @param TaskDTO
	 */
	void save(TaskDTO taskDTO);
}
