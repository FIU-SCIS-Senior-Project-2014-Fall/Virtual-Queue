package com.virtual.queue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.virtual.queue.beans.User;
import com.virtual.queue.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userList.json", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public @ResponseBody void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/removeUser/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void removeUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	@RequestMapping(value = "/getUserByUserName/{uName}", method = RequestMethod.GET)
	public @ResponseBody User getUserByUserName(
			@PathVariable("uName") String userName) {
		return userService.getUserByUserName(userName);
	}

}
