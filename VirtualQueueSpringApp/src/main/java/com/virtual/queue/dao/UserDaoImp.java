package com.virtual.queue.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.virtual.queue.beans.User;

@Repository
//@Transactional
public class UserDaoImp implements UserDao{

	@Override
	public User getUser(String username, String passwd) {
		return User.getDemoUser();
	}

	@Override
	public String getCurrentlyAuthenticatedUserName() {
		 
		return User.getDemoUser().getUserName();
	}

	@Override
	public User getUserByToken(String token) {
		 return User.getDemoUser();
	}

	@Override
	public String storeToken(Long userId) {
		 return User.getDemoUser().getToken();
	}

	@Override
	public List<User> getAll() {
		 List<User> list = new ArrayList<User>(4); 
		 
		 for (int i= 0; i<4; i++){
		 list.add(User.getDemoUser());
		 }
		 return list;
	}

	@Override
	public void addUser(User user) {
		System.out.println("User was suscefully added!");
		
	}

	@Override
	public void updateUser(User user) {
		System.out.println("User was suscefully updated!");
		
	}

	@Override
	public void deleteUserById(Long id) {
		System.out.println("User was suscefully deleted!");
		
	}

	@Override
	public User getUserByUserName(String userName) {
		
		return User.getDemoUser();
	}

}
