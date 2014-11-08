package com.virtual.queue.rule;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtual.queue.beans.Coordinate;
import com.virtual.queue.beans.QueueInfo;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.User;
import com.virtual.queue.dao.QueueDao;
import com.virtual.queue.dao.RideDao;
import com.virtual.queue.exception.NotificationException;
import com.virtual.queue.utility.QueueUtil;

public class AddUserRule implements Rule {

	private final static double WALKING_SPEED_MIN = 0.052;

	private RideInfo ride = null;
	private QueueInfo queueInfo = null;
	private LinkedList<RideInfo> rideList = null;
	private List<User> userList = null;

	@Autowired
	RideDao rideDao;

	@Autowired
	QueueDao queueDao;

	@Override
	public void loadData(long userId, long rideId) {
		// take all rides for that user. using rideDao.
		// select the last ride registered for that user.
		try {

			ride = rideDao.getRideById(rideId);

		} catch (NotificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		queueInfo = queueDao.getQueueInfoByRideId(rideId);
		// if not ride added..Add the new ride and get the waiting time for that
		// user

		// get all rides that user is registered for.
		rideList = queueDao.getRideListByUser(userId);
		// get all user for that queue.
		userList = queueDao.getAllUserQueueForRide(rideId);
		// calculate waiting time (when no other ride exists) by taking all
		// people queued for that ride and divide it by ride_capacity
		// (flooring ex: 50 people queued already/20 can ride simultaneosly=
		// 2.5. so, 20 min waiting time) for that specific ride.
		// calculate ceiling also (ceiling ex: 50people queued already/20 can
		// ride simultaneosly= 2.5. so, 30 min //waiting time (when other rides
		// exists) for that specific ride.
		// NOTE: take ceiling and flooring number per each ride added.
		// Then, to add other ride when user has more rides on his account, take
		// the ceiling number (in this case 30 min) and ADD walking distance
		// calculating longitude and latitude or other way.
		// AND ADD + all other ceiling waiting times for other rides and add
		// them all
		// THEN, compare ride flooring waiting time for ride user is trying to
		// add with the SUM of all ceiling calculated before and make sure the
		// new ride flooring time is greater..so, ride can be added
		// also, check park is not near closing and user hasn't already queued
		// for too many rides

	}

	@Override
	public boolean apply() {
		int waitingTime = 0;
		int rideCap = 0;
		int duration = 0;
		int totalWtime = 0;

		// get ride capacity
		rideCap = ride.getCapacity();
		// get ride duration
		duration = ride.getInterval();

		// queue already full return false;
		if (userList.size() == queueInfo.getCapacity()) {
			return false;
		}
		// user already has been registered for other rides.
		if (!rideList.isEmpty()) {

			for (RideInfo rinfo : rideList) {

				int size = queueDao.getAllUserQueueForRide(rinfo.getRideId())
						.size();

				int wtime = getWaitingTime(size, rinfo.getCapacity(),
						rinfo.getInterval(), false);

				totalWtime += wtime;// all all waiting time from each ride

			}

			RideInfo lastRide = rideList.getLast();
			QueueUtil util = new QueueUtil();
			Coordinate rideCoor = ride.getCoordinate();
			Coordinate lastRideCoor = lastRide.getCoordinate();

			double wDistance = util.calculateDistance(rideCoor.getLatitude(),
					rideCoor.getLongitude(), lastRideCoor.getLatitude(),
					lastRideCoor.getLongitude());
			double wtime = Math.ceil(wDistance / WALKING_SPEED_MIN);
			double finaltime = totalWtime + wtime;

			int count = userList.size();
			// get previous ride.
			waitingTime = getWaitingTime(count, rideCap, duration, true);
			// check wating time.
			if (waitingTime < finaltime)
				return false;

		}

		return true;

	}

	@SuppressWarnings("unused")
	private void ValidationLogic() {

	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub

	}

	private int getWaitingTime(int count, int rideCap, int duration,
			boolean topbot) {
		int wait = 0;

		if (topbot) {
			wait = (int) Math.floor((count / rideCap)) * duration;
		} else {
			wait = (int) Math.ceil((count / rideCap)) * duration;
		}

		return wait;

	}

}
