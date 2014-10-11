package com.virtual.queue.service;

import java.util.List;

import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.User;

import org.springframework.stereotype.Service;

@Service
public class RideServiceImp implements RideService {

	@Override
	public List<Ride> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRide(Ride ride) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRide(Ride ride) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRideById(Long id, Long userid) {
		// TODO Auto-generated method stub

	}
 

	@Override
	public boolean addRideById(Long rideId, Long userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRidebyId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
