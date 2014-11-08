package com.virtual.queue.service;

public interface QueueService {
public boolean removeUserFromQueue(long rideId,long userid);
public boolean removeAllUsersFromQueue(long rideId);
	
	 
}
