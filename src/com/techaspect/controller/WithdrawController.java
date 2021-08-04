package com.techaspect.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.techaspect.atm.service.atmService;
import com.techaspect.atm.to.AccountInfo;
import com.techaspect.atm.to.UserInfo;

@Controller
public class WithdrawController{
atmService atmservice;

@Autowired
	public WithdrawController(atmService atmservice) {
	this.atmservice = atmservice;
}

@RequestMapping(value = "/Withdraw")
public String WithDraw(@RequestParam String withdrawamt, HttpSession session) {
	UserInfo user = (UserInfo)session.getAttribute("User");
	

	AccountInfo account = atmservice.Withdraw(withdrawamt, user);
	
	session.setAttribute("Account", account);

	return "WithdrawSuccess.jsp";
	
}
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = null;	
		
		String amt = req.getParameter("withdrawamt");
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("User");

		
		user = atmserviceinterface.Withdraw(amt, user);
		
		session.setAttribute("User", user);
		modelAndView = new ModelAndView("WithdrawSuccess.jsp");
		return modelAndView;
	}*/


	

}
