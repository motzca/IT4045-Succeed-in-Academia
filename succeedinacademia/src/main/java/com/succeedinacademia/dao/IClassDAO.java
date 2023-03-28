package com.succeedinacademia.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.ClassDTO;

@Component
public interface IClassDAO {

	boolean save(ClassDTO classDTO) throws Exception;
	
	Iterable<ClassDTO> fetchAll() throws Exception;
	
	List<String> fetchAllClassNames() throws Exception;

}
