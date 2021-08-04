package com.techaspect.atm.to;

public class AccountInfo {
	private String user_id;
	private String account_no;
	private String account_bal;
	private String account_type;
	
	public AccountInfo() {
		System.out.println("AccountInfo()");
	}

	public AccountInfo(String user_id, String account_no, String account_bal, String account_type) {
		super();
		this.user_id = user_id;
		this.account_no = account_no;
		this.account_bal = account_bal;
		this.account_type = account_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_bal() {
		return account_bal;
	}

	public void setAccount_bal(String account_bal) {
		this.account_bal = account_bal;
	}

	public String getaccount_type() {
		return account_type;
	}

	public void setaccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	
}
