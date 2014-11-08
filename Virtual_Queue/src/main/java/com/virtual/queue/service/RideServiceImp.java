package com.virtual.queue.service;

import java.util.ArrayList;
import java.util.List;

import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.builder.RuleBuilder;
import com.virtual.queue.builder.RuleBuilderImp;
import com.virtual.queue.dao.RideDao;
import com.virtual.queue.dao.RideDaoImp;
import com.virtual.queue.exception.NotificationException;
import com.virtual.queue.rule.Rule;
import com.virtual.queue.validator.Validator;
import com.virtual.queue.validator.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImp implements RideService {
	@Autowired
	RideDao rideDao;

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
	public boolean addUserRideById(Long rideId, Long userid) throws Exception {

		Validator validator = new ValidatorFactory().getRideValidator();

		RuleBuilder builder = new RuleBuilderImp();
		List<Rule> rules = builder.buildRules();

		validator.setRules(rules);
		validator.validate();

		return true;

	}

	@Override
	public boolean removeRidebyId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RideInfo> pullRideInfo() {

		RideDao rdao = new RideDaoImp();

		try {

			return rdao.pullRideInfo();

		} catch (NotificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO:change this to a valid return value.
		return null;

	}

	@Override
	public RideInfo getRidebyId(long rideId) throws NotificationException {
		return rideDao.getRideById(rideId);
	}
}
