package com.succeedinacademia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.succeedinacademia.dao.IClassDAO;
import com.succeedinacademia.dao.ITaskDAO;
import com.succeedinacademia.dto.ClassDTO;

@Component
public class ClassService implements IClassService {

	@Autowired
	IClassDAO classDAO;
	
	@Autowired
	ITaskDAO taskDAO;
	
	@Override
	public ClassDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(ClassDTO classDTO) throws Exception {
		// TODO Auto-generated method stub
		classDAO.save(classDTO);
		return false;
	}
	
	
	@Override
	public Iterable<ClassDTO> fetchAllClasses() throws Exception {
		return classDAO.fetchAll();
	}

}
