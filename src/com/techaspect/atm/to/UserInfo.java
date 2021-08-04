package com.techaspect.atm.to;

public class UserInfo {
	private String user_id;
	private String cust_id;
	private String fname;
	private String lname;
	private String pin;
	private String password;
	
	public UserInfo() {
	}
	
	public UserInfo(String user_id, String cust_id, String fname, String lname, String pin, String password) {
		this.user_id = user_id;
		this.cust_id = cust_id;
		this.fname = fname;
		this.lname = lname;
		this.pin = pin;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
