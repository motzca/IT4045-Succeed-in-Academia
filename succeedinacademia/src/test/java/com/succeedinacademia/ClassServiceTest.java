package com.succeedinacademia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.succeedinacademia.dto.ClassDTO;
import com.succeedinacademia.service.IClassService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class ClassServiceTest {

	@Autowired
	IClassService classService;
	ClassDTO myClass;
	
	@Test
	public void fetchGrade_whenUserClicksOnAClass() {
		whenTheUserClicksOnAClass();
		thenShowGrade();
	}

	private void whenTheUserClicksOnAClass() {
		myClass = classService.fetchById(1);
	}
	
	private void thenShowGrade() {
		assertEquals("The grade is returned", "100.0", myClass.getGrade());
	}
	
}
