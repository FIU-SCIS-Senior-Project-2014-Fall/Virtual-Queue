package com.virtual.queue.beans;

import java.util.Date;

public class RideInfo {
public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
private String rName;
public int getInterval() {
	return interval;
}
public void setInterval(int interval) {
	this.interval = interval;
}
private String description;
private Date startTime;
private Date endTime;
private int interval;
	
	
}
