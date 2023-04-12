package com.succeedinacademia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.succeedinacademia.dto.ClassDTO;

@Component
public class ClassServiceStub implements IClassService {
	
	@Override
	public ClassDTO fetchById(int id) {
		ClassDTO classDTO = new ClassDTO();
		classDTO.setClassId(1);
		classDTO.setClassName("Enterprise App Development");
		classDTO.setGrade("100.0");
		return classDTO;
		
	}
	
	@Override
	public boolean save(ClassDTO classDTO) throws Exception {
		return false;
		
	}

	@Override
	public Iterable<ClassDTO> fetchAllClasses() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> fetchAllClassNames() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws Exception {
		return;
	}
	
	@Override
	public void updateClass(ClassDTO classDTO) throws Exception {
		return;
	}

}
