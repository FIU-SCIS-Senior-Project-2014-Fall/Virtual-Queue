package com.virtual.queue.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;

public class DBUtil {

	public static class DBUtility {

		private static Connection connection = null;
		private static String URL="jdbc:mysql://127.0.0.1:3306/VirtualQueue";
		private static String USER="root";
		private static String PASSWORD="ok";
		private static String DRIVER="com.mysql.jdbc.Driver";

		@Autowired
		private static DataSource dataSource;

		public static void printConnection() {

			System.out.println(dataSource.getDriver());
			System.out.println(dataSource.getJdbcUrl());
			System.out.println(dataSource.getPassword());
			System.out.println(dataSource.getUserName());
		}

		public static Connection getConnection() {

			if (connection != null)

				return connection;

			else {

				try {
/*
					Properties prop = new Properties();

					InputStream inputStream = (InputStream) DBUtil.class
							.getClassLoader().getResourceAsStream(
									"config.properties");

					prop.load(inputStream);
*/
					String driver =DRIVER; //prop.getProperty("driver");

					String url = URL;//prop.getProperty("url");

					String user =USER;// prop.getProperty("user");

					String password =PASSWORD;// prop.getProperty("password");

					Class.forName(driver);
				
					connection = DriverManager.getConnection(url, user,
							password);

				} catch (ClassNotFoundException e) {

					e.printStackTrace();

				} catch (SQLException e) {

					e.printStackTrace();
				}
			/*		
				} catch (FileNotFoundException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();

				}
*/
				return connection;

			}

		}

	}

}
