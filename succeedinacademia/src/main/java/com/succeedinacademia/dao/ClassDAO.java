package com.succeedinacademia.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.ClassDTO;

@Component
public class ClassDAO implements IClassDAO {
	
	@Autowired
	ClassRepository classRepository;

	@Override
	public boolean save(ClassDTO classDTO) throws Exception {
		// TODO Auto-generated method stub
		classRepository.save(classDTO);
		return false;
	}

	@Override
	public Iterable<ClassDTO> fetchAll() throws Exception {
		// TODO Auto-generated method stub
		return classRepository.findAll();
	}

}
