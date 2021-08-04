package com.techaspect.atm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techaspect.atm.dao.DBconnection;
import com.techaspect.atm.to.AccountInfo;
import com.techaspect.atm.to.UserInfo;

@Component
public class atmService {
	DBconnection dbconnectionhibernate ;
	UserInfo user;
	AccountInfo account;;

	@Autowired
	public atmService(DBconnection dbconnection) {
		System.out.println("atmservice");
		this.dbconnectionhibernate = dbconnection;
	}
	

	public UserInfo CheckCredentials(UserInfo user1) {
		user   = dbconnectionhibernate.LoginUser(user1);
		//System.out.println( user.getFname() + " atmservice");
		
		return user;
		
	}


	public AccountInfo Withdraw(String amt,UserInfo user) {
		
		account = dbconnectionhibernate.Withdraw(account,amt , user.getUser_id());
		return account;
	}

	
	public AccountInfo BalanceEnquiry(UserInfo user) {
		account = dbconnectionhibernate.BalanceEnquiry(account, user.getUser_id());
		
		return account;
		
	}


	public ArrayList MiniStatement(String id) {
		
		
		ArrayList al =	dbconnectionhibernate.MiniStatement(id);
		return al;
			
	}
	

}
