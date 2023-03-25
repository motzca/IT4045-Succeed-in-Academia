package com.succeedinacademia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.succeedinacademia.dao.IClassDAO;
import com.succeedinacademia.dao.ITaskDAO;
import com.succeedinacademia.dto.ClassDTO;

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

}
