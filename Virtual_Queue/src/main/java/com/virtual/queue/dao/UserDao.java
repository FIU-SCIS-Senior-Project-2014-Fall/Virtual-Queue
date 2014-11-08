package com.virtual.queue.dao;

import java.util.List;

import com.virtual.queue.beans.User;

public interface UserDao {

	public User getUser(String username, String passwd); 
	public String getCurrentlyAuthenticatedUserName(); 
	public User getUserByToken(String token);
	public String storeToken(Long userId);
    public List<User> getAll(); 
    public void addUser(User user);
	public void updateUser(User user);
	public void deleteUserById(Long id);
	public User getUserByUserName(String userName);
	public Boolean resetPassword(String userName, String securityAnswer,
			String securityQuestion, String newPassword) throws Exception;
	public User authenticateUser(String userName,String securityQuestion,String securityAnwser);
	public User getUserById(long userId);
	public boolean removeUserFromQueue(long userId,long rideId);

}
