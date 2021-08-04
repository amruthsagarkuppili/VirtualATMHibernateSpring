package com.techaspect.atm.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.techaspect.atm.to.AccountInfo;
import com.techaspect.atm.to.TransactionInfo;

import com.techaspect.atm.to.UserInfo;

@Component
public class DBconnection {
	SessionFactory sessionFactory;
	@Autowired
	public DBconnection(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserInfo LoginUser(UserInfo user) {
		
		String hql = "FROM UserInfo u WHERE  u.pin = '" + user.getPin() + "'";
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);

		List list = query.list();
		if (!list.isEmpty()) {
			for (Object o : list) {
				user = (UserInfo) o;
				// System.out.println("Fname : " + user.getFname() + "\nLname :
				// " +user.getLname());

			}
			session.close();
			
			return user;
		}

		session.close();
		
		return null;
	}

	public AccountInfo BalanceEnquiry(AccountInfo account, String id) {
		String hql = "FROM AccountInfo a WHERE  a.user_id = '" + id + "'";
	
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);

		List list = query.list();
		for (Object o : list) {
			account = (AccountInfo) o;
			// System.out.println("Balance : " + account.getAccount_bal() +
			// "\nAccount no : "+ account.getAccount_no() );

		}
		session.close();
		return account;

	}

	public ArrayList MiniStatement(String id) {

		String hql = "FROM TransactionInfo t WHERE  t.user_id = '" + id + "'";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List li = query.list();
		ArrayList al = null;
		if (!li.isEmpty()) {
			al = new ArrayList(li);
		}
		session.close();
		return al;
	}

	public AccountInfo Withdraw(AccountInfo account, String amt, String id) {

		String hql = "FROM AccountInfo a WHERE  a.user_id = '" + id + "'";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);

		List list = query.list();
		
		for (Object o : list) {
			account = (AccountInfo) o;
			 System.out.println("Balance : " + account.getAccount_bal() +
			 "\nAccount no : "+ account.getAccount_no() );

		}
		int amount = Integer.parseInt(amt);
		int final_bal = Integer.parseInt(account.getAccount_bal()) - amount;

		account = (AccountInfo) session.get(AccountInfo.class, id);
		account.setAccount_bal(String.valueOf(final_bal));
		System.out.println(final_bal);
		System.out.println("before update");
		session.update(account);
		System.out.println("after update");

		TransactionInfo trans = new TransactionInfo();
		trans.setUser_id(id);
		Random rand = new Random();
		int temp = rand.nextInt(999999);
		trans.setTrans_id(String.valueOf(temp));
		trans.setTrans_amt(amt + " dr");
		trans.setTrans_date(String.valueOf(new Date()));
		session.save(trans);
		tx.commit();

		session.close();
		return account;
	}

}
