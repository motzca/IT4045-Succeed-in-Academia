package com.succeedinacademia.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<String> fetchAllClassNames() throws Exception {
	    List<String> classNames = new ArrayList<>();
	    List<ClassDTO> classDTOs = (List<ClassDTO>) classRepository.findAll();
	    for (ClassDTO classDTO : classDTOs) {
	        classNames.add(classDTO.getClassName());
	    }
	    return classNames;
	}

}
