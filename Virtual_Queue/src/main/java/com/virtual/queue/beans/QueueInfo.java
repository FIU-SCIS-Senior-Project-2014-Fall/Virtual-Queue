package com.virtual.queue.beans;

public class QueueInfo {

	private String name;
	private Integer maxValue;
	private String phoneNumber;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isValid(){
		if(name!=null || "".equalsIgnoreCase(""))return false;
		//TODO:add all validations for this class.s
	return true;
		
		
	}
	
	
}
