package com.succeedinacademia.dao;

import org.springframework.data.repository.CrudRepository;

import com.succeedinacademia.dto.TaskDTO;

public interface TaskRepository extends CrudRepository<TaskDTO, Integer> {

}
