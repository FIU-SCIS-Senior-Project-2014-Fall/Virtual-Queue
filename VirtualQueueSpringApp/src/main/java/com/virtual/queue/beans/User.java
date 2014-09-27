package com.virtual.queue.beans;

public class User {
	private Long userid;

	private String firstName;

	private String lastName;

	private String email;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserid() {

		return userid;

	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUserid(Long userid) {

		this.userid = userid;

	}

	public String getFirstName() {

		return firstName;

	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;

	}

	public String getLastName() {

		return lastName;

	}

	public void setLastName(String lastName) {

		this.lastName = lastName;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	@Override
	public String toString() {

		return "User [userid=" + userid + ", firstName=" + firstName

		+ ", lastName=" + lastName + ", email="

		+ email + "]";

	}

	public static User getDemoUser() {

		User demoUser = new User();

		demoUser.setEmail("test@gmail.com");
		demoUser.setFirstName("DemoName");
		demoUser.setLastName("DemoLastName");
		demoUser.setUserid(1111L);
		demoUser.setToken("123456");
		return demoUser;

	}
}
