package com.example.demo;

public class user {

	String user_name;
	String password;
	String phone_number;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "user [user_name=" + user_name + ", password=" + password + ", phone_number=" + phone_number + "]";
	}
	
	
    

	
}
