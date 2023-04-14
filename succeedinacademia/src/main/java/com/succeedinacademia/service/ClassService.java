package com.succeedinacademia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.succeedinacademia.dao.ClassRepository;
import com.succeedinacademia.dao.IClassDAO;
import com.succeedinacademia.dao.ITaskDAO;
import com.succeedinacademia.dto.ClassDTO;

@Component
public class ClassService implements IClassService {
	
	private static List<ClassDTO> classNames = new ArrayList<>();

	@Autowired
	IClassDAO classDAO;
	
	@Autowired
	ITaskDAO taskDAO;
	
	@Autowired
	ClassRepository classRepository;
	
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
	
	@Override
	public List<String> fetchAllClassNames() throws Exception {
		return classDAO.fetchAllClassNames();
	}
	
	@Override
	public void delete(int id) throws Exception {
		classDAO.delete(id);
	}
	
	public void updateClass(ClassDTO classDTO) throws Exception {
		classRepository.save(classDTO);
		classDAO.save(classDTO);
	}

}
