package com.techaspect.atm.to;

public class TransactionInfo {
	private String user_id;
	private String trans_id;
	private String trans_date;
	private String trans_amt;
	
	public TransactionInfo() {
	}
	public TransactionInfo(String user_id, String trans_id, String trans_date, String trans_amt) {
		super();
		this.user_id = user_id;
		this.trans_id = trans_id;
		this.trans_date = trans_date;
		this.trans_amt = trans_amt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public String getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}
	public String getTrans_amt() {
		return trans_amt;
	}
	public void setTrans_amt(String trans_amt) {
		this.trans_amt = trans_amt;
	}	
}
