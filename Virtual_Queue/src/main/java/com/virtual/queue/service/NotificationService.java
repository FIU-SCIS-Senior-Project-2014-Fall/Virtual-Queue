package com.virtual.queue.service;

import java.util.List;

import com.virtual.queue.beans.QueueInfo;

public interface NotificationService {
	public List<QueueInfo> pullNotInfo(Integer rideId);
	public List<QueueInfo> pullAllNotInfo();
	
	public void notifyUser(Integer rideId) throws Exception;
	public void notifyAllUsers() throws Exception;
}
