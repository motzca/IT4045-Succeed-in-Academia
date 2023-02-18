package com.succeedinacademia.dto;

public class TaskDTO {

	private int guid;
	private String item;
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
