package com.succeedinacademia.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TaskDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GUID")
	private int guid;
	
	@Column(name="ITEM")
	private String item;
	
	@ManyToOne
	@JoinColumn(name = "CLASS_ID")
	private ClassDTO myClass;
	
	public int getGuid() {
		return guid;
	}
	public void setGuid(int guid) {
		this.guid = guid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public ClassDTO getMyClass() {
		return myClass;
	}
	public void setMyClass(ClassDTO myClass) {
		this.myClass = myClass;
	}
	
	
}
