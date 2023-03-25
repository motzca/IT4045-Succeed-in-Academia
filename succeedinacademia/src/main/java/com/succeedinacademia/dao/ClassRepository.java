package com.succeedinacademia.dao;

import org.springframework.data.repository.CrudRepository;

import com.succeedinacademia.dto.ClassDTO;

public interface ClassRepository extends CrudRepository<ClassDTO, Integer> {

}
