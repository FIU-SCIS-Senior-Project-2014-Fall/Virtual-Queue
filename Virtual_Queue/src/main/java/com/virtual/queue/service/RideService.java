package com.virtual.queue.service;

import java.util.List;

import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.User;
 

public interface RideService {

	List<Ride> getAll();
	void addRide(Ride ride);
	void updateRide(Ride ride); 
	void deleteRideById(Long id, Long userid);
	boolean removeRidebyId(String id);
	boolean addRideById(Long rideId, Long userid);

}
