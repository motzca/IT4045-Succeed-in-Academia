package com.succeedinacademia.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.TaskDTO;

@Component
public interface ITaskDAO {

	boolean save(TaskDTO taskDTO) throws Exception;
	
	Iterable<TaskDTO> fetchAll() throws Exception;
	
	List<TaskDTO> fetchTasksByClassId(int classId);
	
	void delete(int id);

}
