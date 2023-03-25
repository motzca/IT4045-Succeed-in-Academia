package com.succeedinacademia.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="classes")
public class ClassDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLASS_ID")
	private int classId;
	
    @Column(name="CLASS_NAME")
	private String className;
    
    @Column(name="GRADE")
	private String grade;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
