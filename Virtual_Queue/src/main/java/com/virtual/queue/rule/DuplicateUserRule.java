package com.virtual.queue.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.User;
import com.virtual.queue.dao.RideDao;
import com.virtual.queue.dao.RuleDao;
import com.virtual.queue.dao.UserDao;
import com.virtual.queue.exception.NotificationException;

public class DuplicateUserRule implements Rule {

	public static final int MAX_RIDE_PER_USER = 3;

	@Autowired
	RuleDao ruleDao;

	private User user = null;
	private int rideCount = 0;

	@Autowired
	UserDao userDao;

	@Autowired
	RideDao rideDao;

	@Override
	public boolean apply() {
		if (user == null) {
			return false;
		}
		if (rideCount > MAX_RIDE_PER_USER) {
			return false;
		}

		return true;
	}

	@Override
	public void loadData(long userId, long rideId) {

		user = userDao.getUserById(userId);
		List<RideInfo> list;
		try {
			list = rideDao.getRideByUser(userId);

			rideCount = list.size();

		} catch (NotificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub

	}

}
