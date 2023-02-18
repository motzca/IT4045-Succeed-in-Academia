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
	public void save(ClassDTO classDTO) {
		
	}

}
