package com.virtual.queue.dao;

public interface LoginDao {
      public Long validLogin(String user,String password); 
	  public boolean signIn(String userId,String password);
	  public boolean signOut(String userId);
}
