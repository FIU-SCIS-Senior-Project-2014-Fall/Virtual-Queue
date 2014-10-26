package com.virtual.queue.beans;

import java.io.Serializable;

public class User extends AbstractUser implements Serializable {

	private static final long serialVersionUID = 7503398206106993501L;

	private String _code;
	private String _password;
	private String _email;
	private String _securityAnswer;
	private String _phoneNumber;
	private Role _userRole;
	private String _securityQuestion;
	private String _age;
	private String _height;
	private String _weight;
	

	public User() {
	}

	public User(String code, String password, String email,
			String securityAnswer, String securityQuestion, String phoneNumber,
			Role role, String age, String height, String weight) {

		_code = code;
		_password = password;
		_email = email;
		_securityAnswer = securityAnswer;
		_securityQuestion = securityQuestion;
		_phoneNumber = phoneNumber;
		_age = age;
		_height = height;
		_weight = weight;
		setUserRole(role);

	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		this._code = code;
	}

	private String securityQuestion;

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private Long userid;

	private String firstName;

	private String lastName;

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	public String getSecurityAnswer() {
		return _securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this._securityAnswer = securityAnswer;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this._phoneNumber = phoneNumber;
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

		return _email;

	}

	public void setEmail(String email) {

		this._email = email;

	}

	@Override
	public String toString() {

		return "User [firstName=" + firstName

		+ ", lastName=" + lastName + ", _email="

		+ _email + ", _password=" + _password + ", _securityAnswer="
				+ _securityAnswer + ", _phoneNumber=" + _phoneNumber
				+ ", securityQuestion=" + securityQuestion + "]";

	}

	public static User getDemoUser() {

		User demoUser = new User();

		demoUser.setEmail("test@gmail.com");
		demoUser.setFirstName("DemoName");
		demoUser.setLastName("DemoLastName");
		demoUser.setUserid(1111L);
		demoUser.setToken("123456");
		demoUser.setUserName("test@test.com");
		return demoUser;

	}

	
	@Override
	public Boolean isNill() {

		return false;
	}

	public String get_securityQuestion() {
		return _securityQuestion;
	}

	public void set_securityQuestion(String _securityQuestion) {
		this._securityQuestion = _securityQuestion;
	}

	public Role getUserRole() {
		return _userRole;
	}

	public void setUserRole(Role _userRole) {
		this._userRole = _userRole;
	}

	 

	public String getAge() {
		return _age;
	}

	public void setAge(String _age) {
		this._age = _age;
	}

	public String getHeight() {
		return _height;
	}

	public void setHeight(String _height) {
		this._height = _height;
	}

	public String getWeight() {
		return _weight;
	}

	public void setWeight(String _weight) {
		this._weight = _weight;
	}

}
