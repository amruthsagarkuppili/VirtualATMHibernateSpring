package com.techaspect.controller;



import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.techaspect.atm.service.atmService;
import com.techaspect.atm.to.TransactionInfo;
import com.techaspect.atm.to.UserInfo;

@Controller
public class MiniStatementController {
	atmService atmservice;
	
	@Autowired
	public MiniStatementController(atmService atmservice) {
		this.atmservice = atmservice;
	}

@RequestMapping(value = "/MiniStatement")
public String Ministatement(HttpSession session) {
	
	UserInfo user =(UserInfo) session.getAttribute("User");
	ArrayList al = atmservice.MiniStatement( user.getUser_id());
	
	session.setAttribute("User", user);
	session.setAttribute("Transaction", al);
	return "MiniStatement.jsp";
}
	


/*	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = null;
		
		HttpSession session = req.getSession();	
		User user =(User) session.getAttribute("User");
		user = atmserviceinterface.MiniStatement( user);
		
		session.setAttribute("User", user);
		modelAndView = new ModelAndView("MiniStatement.jsp");
		return modelAndView;
	}*/

}
