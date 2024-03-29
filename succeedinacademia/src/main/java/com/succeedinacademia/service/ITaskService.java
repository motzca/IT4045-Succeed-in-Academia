package com.succeedinacademia.service;

import com.succeedinacademia.dto.TaskDTO;

/**
 * CRUD operations for tasks
 * @author Administrator
 *
 */
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
	boolean save(TaskDTO taskDTO) throws Exception;

	Iterable<TaskDTO> fetchAllTasks() throws Exception;

	void updateTask(TaskDTO taskDTO) throws Exception;
	
	void delete(int id) throws Exception;
}
