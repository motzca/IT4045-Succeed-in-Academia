package com.succeedinacademia.dao;

import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.ClassDTO;

@Component
public interface IClassDAO {

	boolean save(ClassDTO classDTO) throws Exception;
	
	Iterable<ClassDTO> fetchAll() throws Exception;

}
