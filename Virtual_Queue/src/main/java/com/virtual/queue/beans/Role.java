package com.virtual.queue.beans;

public class Role {
	
	String role_id;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	String role_type;
	String role_desc;
	boolean enable;

}
