package com.succeedinacademia.service;

import java.util.List;

import com.succeedinacademia.dto.ClassDTO;

/**
 * CRUD operations for classes
 * @author Administrator
 *
 */
public interface IClassService {
	
	/**
	 * Get tasks from persistence layer.
	 * @param id a unique lookup.
	 * @return a task with a matching ID. 
	 */
	ClassDTO fetchById(int id);
	
	/**
	 * Persist the given DTO.
	 * @param TaskDTO
	 */
	boolean save(ClassDTO classDTO) throws Exception;

	Iterable<ClassDTO> fetchAllClasses() throws Exception;

	List<String> fetchAllClassNames() throws Exception;

	void delete(int id) throws Exception;

	void updateClass(ClassDTO classDTO) throws Exception;
}
