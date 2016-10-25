package com.beyang.cn.entity;

public class User {
	private String userNo;
	private String userName;
	private String password;
	private String email;
	private Integer age;
	private String address;
	
	
	public User() {
	}
	public User(String userName, String password, String email, Integer age) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
	}
	
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", age=" + age
				+ ", address=" + address + "]";
	}
	
	
}
