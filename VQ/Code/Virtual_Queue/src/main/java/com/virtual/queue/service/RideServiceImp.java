package com.virtual.queue.service;

import java.util.List;

import com.virtual.queue.beans.NotificationInfo;
import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.RuleCapacityBean;
import com.virtual.queue.beans.User;
import com.virtual.queue.builder.RuleBuilderImp;
import com.virtual.queue.dao.QueueDao;
import com.virtual.queue.dao.RideDao;
import com.virtual.queue.dao.UserDao;
import com.virtual.queue.exception.NotificationException;
import com.virtual.queue.handler.EmailNotificationHandlerImp;
import com.virtual.queue.handler.NotificationHandler;
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

	@Autowired
	UserDao userDao;
public RideServiceImp(){}
	
	public RideServiceImp(RideDao rideD,QueueDao queueD,UserDao userD){
		rideDao=rideD;
		queueDao=queueD;
		userDao=userD;
		 
	}

	@Override
	public List<RideInfo> getAll() throws Exception {

		List<RideInfo> list = rideDao.getAll();

		for (RideInfo info : list) {
			// get all data to calculate waiting time.

			int count = queueDao.getAllUserQueueForRide(info.getRideId())
					.size();
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
		boolean result = false;

		// RuleBuilder builder = new RuleBuilderImp();
		List<Rule> rules = new RuleBuilderImp().buildRules();

		validator.setRules(rules);

		if (validator.validate(userid, rideId)) {

			// add user to ride/queue
			result = rideDao.addUserRideById(rideId, userid);

			/*
			 * check queue size and ride capacity. if there is no user on the
			 * queue yet, or the amount of users is less than the ride
			 * capacity,then notify this user just after add him/her to this
			 * queue.
			 */

			List<User> users = queueDao.getAllUserQueueForRide(rideId);
			
			User user = userDao.getUserById(userid);
			
			RideInfo info = rideDao.getRideById(rideId);

			if (users != null && info != null && user!=null) {
				// Check for biz rules
				if (users.size() <= info.getCapacity()) {

					NotificationHandler handler = new EmailNotificationHandlerImp();
					NotificationInfo notInfo = new NotificationInfo();
					// set data
					notInfo.setEmail(user.getEmail());
					notInfo.setName(user.getFirstName() + " , "
							+ user.getLastName());
					notInfo.setEmail(user.getEmail());

					double timeMin = info.getInterval() / 60.0;
					notInfo.setMessage("Your "
							+ info.getrName()
							+ " ride is due in :"
							+ timeMin
							+ "minute/s, Please, try to be on time and Enjoy your Ride :) ");
					// notify user
					handler.notifiyUser(notInfo);

				}

			}

		}
		return result;

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
