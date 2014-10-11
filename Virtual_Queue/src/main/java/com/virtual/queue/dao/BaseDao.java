package com.virtual.queue.dao;

import java.sql.Connection;

import com.virtual.queue.utility.DBUtil.DBUtility;
 

public abstract class BaseDao {

	protected Connection connection;

	public Connection getConnection() {
		   connection = DBUtility.getConnection();
	   return connection;
	}
 
}
