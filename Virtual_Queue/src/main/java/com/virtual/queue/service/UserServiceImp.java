package com.virtual.queue.service;

import java.util.List;
 








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtual.queue.beans.User;
import com.virtual.queue.dao.ResetPasswordDao;
import com.virtual.queue.dao.UserDao;
import com.virtual.queue.request.UserPasswordResetRequest;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ResetPasswordDao resetPassDao;
	
	@Override
	public User getUser(String username, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentlyAuthenticatedUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String storeToken(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetPassword(UserPasswordResetRequest passwordReset) throws Exception {
		 
		resetPassDao.resetPassword(passwordReset.getUserName(),
				passwordReset.getSecurityAnswer(),passwordReset.getSecurityQuestion(),passwordReset.getNewPassword());
		
		
		
		 
	}

	 
}
