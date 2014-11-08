package com.virtual.queue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.User;
import com.virtual.queue.beans.UserRolesEnum;
import com.virtual.queue.service.RideService;

@Controller
@RequestMapping("/ride")
@SessionAttributes({ "user" })
public class RideController {
	@Autowired
	private RideService rideService;

	@RequestMapping("/rides.json")
	public @ResponseBody List<Ride> getAllRides() {
		return rideService.getAll();
	}

	@RequestMapping(value = "/addRide", method = RequestMethod.POST)
	public @ResponseBody void addRide(@RequestBody Ride ride,
			@ModelAttribute User user) { 
		rideService.addRide(ride);
		 
	}

	@RequestMapping(value = "/updateRide", method = RequestMethod.PUT)
	public @ResponseBody void updateRide(@RequestBody Ride ride) {
		rideService.updateRide(ride);
	}

	@RequestMapping(value = "/removeRide/{rideid}/{userid}", method = RequestMethod.DELETE)
	public @ResponseBody void removeRideByUser(
			@PathVariable("rideid") Long rideId,
			@PathVariable("userid") Long userid) {
		rideService.deleteRideById(rideId, userid);
	}

	@RequestMapping(value = "/addRide/{rideid}/{userid}", method = RequestMethod.POST)
	public @ResponseBody boolean addrideByUser(@PathVariable("rideid") Long rideId,
			@PathVariable("userid") Long userid) {
		try {
			return rideService.addUserRideById(rideId, userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}

	@RequestMapping(value = "/removeRide/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean removeRideById(@PathVariable("id") String id) {
		 return rideService.removeRidebyId(id);
	}

	@RequestMapping("/layout")
	public String getUserPartialPage(ModelMap modelMap) {
		return "users/layout";
	}
}
