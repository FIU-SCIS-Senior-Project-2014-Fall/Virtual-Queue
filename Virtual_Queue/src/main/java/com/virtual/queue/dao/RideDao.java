package com.virtual.queue.dao;

import java.util.List;

import com.virtual.queue.beans.RideInfo;

public interface RideDao {
	public List<RideInfo> pullRideInfo() ;
	
}
