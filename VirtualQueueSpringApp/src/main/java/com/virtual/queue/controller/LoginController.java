package com.virtual.queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody; 
import com.virtual.queue.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/signin/{userid}/{password}")
	public @ResponseBody boolean signIn(@PathVariable("userid") String userId,
			@PathVariable("password") String password) {

		return loginService.signIn(userId, password);
	}

	@RequestMapping("/signout")
	public @ResponseBody boolean signOut(@PathVariable("userid") String userId) {
		return loginService.signOut(userId);
	}

	@RequestMapping("/layout")
	public String getIndexPage() {
		return "login/layout";
	}

}
