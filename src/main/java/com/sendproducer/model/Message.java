package com.sendproducer.model;

import java.util.List;

public class Message {

	private String givenMessage;
	
	public Message() {
	}

	public Message(String givenMessage, List<EmployeeDetails> empList) {
		super();
		this.givenMessage = givenMessage;
		this.empList = empList;
	}

	public String getGivenMessage() {
		return givenMessage;
	}

	public void setGivenMessage(String givenMessage) {
		this.givenMessage = givenMessage;
	}

	private List<EmployeeDetails> empList;

	

	public List<EmployeeDetails> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDetails> empList) {
		this.empList = empList;
	}

}
