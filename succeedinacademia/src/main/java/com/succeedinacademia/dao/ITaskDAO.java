package com.succeedinacademia.dao;

import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.TaskDTO;

@Component
public interface ITaskDAO {

	boolean save(TaskDTO taskDTO) throws Exception;

}
