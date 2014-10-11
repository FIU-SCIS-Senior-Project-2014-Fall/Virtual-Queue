package com.virtual.queue.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.virtual.queue.beans.User;
import com.virtual.queue.request.LoginRequest;
import com.virtual.queue.service.LoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/signin")
	public @ResponseBody Boolean signIn(LoginRequest login,
			HttpServletRequest request) {
		if (!login.validate())
			return Boolean.FALSE;
		// set user value on session
		ModelAndView modelAndView = new ModelAndView();

		User user = loginService.signIn(login.getUserName(),
				login.getPassword(), login.getCode());

		if (user.isNill())
			return Boolean.FALSE;
		;

		modelAndView.addObject("user", user);

		/*
		 * if (request != null) {
		 * 
		 * HttpSession session = request.getSession(); if (session != null) {
		 * User user = loginService.signIn(login.getUserName(),
		 * login.getPassword(), login.getCode()); session.setAttribute("user",
		 * user); } }
		 */

		return Boolean.TRUE;
	}

	@RequestMapping("/signout")
	public @ResponseBody boolean signOut(@PathVariable("userid") String userId,
			HttpServletRequest request) {

		/*
		 * Boolean result=Boolean.TRUE;
		 * 
		 * if(userId ==""){
		 * 
		 * result= false;
		 * 
		 * } if (request != null) {
		 * 
		 * HttpSession session = request.getSession(); if (session != null) {
		 * session.setAttribute("user", ""); session.invalidate(); }else{
		 * 
		 * result= false;
		 * 
		 * } }
		 */
		return true;// result;
	}

	@RequestMapping("/layout")
	public String getIndexPage() {
		return "login/layout";
	}

}
