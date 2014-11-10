package com.virtual.queue.dao;

import java.util.LinkedList;
import java.util.List;

import com.virtual.queue.beans.QueueInfo;
import com.virtual.queue.beans.UserQueueInfo;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.User;

public interface QueueDao {
	public List<UserQueueInfo> pullInfo(Integer rideId);

	public List<UserQueueInfo> pullAllInfo(); 

	public LinkedList<User> getAllUserQueueForRide(long rideId);

	public QueueInfo getQueueInfoByRideId(long rideId);

	public boolean removeUserFromQueue(long rideId, long userid);

	public boolean removeAllUsersFromQueue(long rideId);

	public LinkedList<RideInfo> getRideListByUser(long userId) throws Exception;
}
