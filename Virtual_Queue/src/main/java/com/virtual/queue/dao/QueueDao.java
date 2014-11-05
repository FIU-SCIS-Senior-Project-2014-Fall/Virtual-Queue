package com.virtual.queue.dao;

import java.util.List;

import com.virtual.queue.beans.QueueInfo;

public interface QueueDao {
	public List<QueueInfo> pullInfo(Integer rideId);
	public List<QueueInfo> pullAllInfo();

	 
}
