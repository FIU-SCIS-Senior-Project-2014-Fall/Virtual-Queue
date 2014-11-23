package com.virtual.queue.service;

import java.util.List;

import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.RuleCapacityBean;
import com.virtual.queue.builder.RuleBuilderImp;
import com.virtual.queue.dao.QueueDao;
import com.virtual.queue.dao.RideDao;
import com.virtual.queue.exception.NotificationException;
import com.virtual.queue.rule.Rule;
import com.virtual.queue.utility.QueueUtil;
import com.virtual.queue.validator.Validator;
import com.virtual.queue.validator.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImp implements RideService {
	@Autowired
	RideDao rideDao;

	@Autowired
	QueueDao queueDao;

	@Autowired
	RuleService ruleService;

	@Override
	public List<RideInfo> getAll() throws Exception {
		
		
		List<RideInfo> list = rideDao.getAll();
		

		for (RideInfo info : list) {
			// get all data to calculate waiting time.

			int count = queueDao.getAllUserQueueForRide(info.getRideId()).size();
			int capacity = info.getCapacity();
			int interval = info.getInterval();

			long waitingTime = QueueUtil.getWaitingTime(count, capacity,
					interval, true);

			info.setWaitingTime(waitingTime);

		}

		return list;
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

		queueDao.removeUserFromQueue(id, userid);

	}

	@Override
	public boolean addUserRideById(Long rideId, Long userid) throws Exception {

		Validator validator = new ValidatorFactory().getRideValidator();

		// RuleBuilder builder = new RuleBuilderImp();
		List<Rule> rules = new RuleBuilderImp().buildRules();

		validator.setRules(rules);
		if (validator.validate(userid, rideId)) {

			return rideDao.addUserRideById(rideId, userid);

		}
		return false;

	}

	@Override
	public boolean removeRidebyId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RideInfo> pullRideInfo() throws NotificationException {

		return rideDao.pullRideInfo();

	}

	@Override
	public RideInfo getRidebyId(long rideId) throws NotificationException {
		return rideDao.getRideById(rideId);
	}

	@Override
	public List<RideInfo> getRidesByUser(long userId) throws Exception {

		List<RideInfo> list = rideDao.getRideByUser(userId);
		RuleCapacityBean bean = null;

		for (RideInfo info : list) {
			// get all data to calculate waiting time.
			bean = ruleService.loadDataRule(userId, info.getRideId());

			int count = bean.getUserList().size();
			int capacity = bean.getRide().getCapacity();
			int interval = bean.getRide().getInterval();

			long waitingTime = QueueUtil.getWaitingTime(count, capacity,
					interval, true);

			info.setWaitingTime(waitingTime);

		}

		return list;

	}

}
