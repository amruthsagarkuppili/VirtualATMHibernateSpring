package com.techaspect.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techaspect.atm.service.atmService;
import com.techaspect.atm.to.UserInfo;

@Controller
public class LoginProcessController {
atmService atmservice;


@Autowired
	public LoginProcessController(atmService atmservice) {
	System.out.println("Login process");
	this.atmservice = atmservice;
}
@RequestMapping( "/")
public String Entry() {
	return "Home.jsp";
}
@RequestMapping(value = "/LoginProcess")
public String Login(@RequestParam String cid,@RequestParam String pwd,@RequestParam String pin,HttpSession session) {
	UserInfo user = new UserInfo();
	user.setPin(pin);
	user.setCust_id(cid);
	user.setPassword(pwd);
	
	user = atmservice.CheckCredentials(user);
	
	
	if(user != null) {
		session.setAttribute("User", user);
		
		return "LoginSuccess.jsp";
		
		
	}
	else {
		return "LoginFailed.jsp";
		
	}
	
}

	/*@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = null;
		
		String pin = req.getParameter("pin");
		String cid = req.getParameter("cid");
		String pass = req.getParameter("pwd");
		
		User user = new User();
		user.setPin(pin);
		user.setCust_id(cid);
		user.setPassword(pass);
		
		
		
		WebApplicationContext springContainer = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		atmService atmService = springContainer.getBean(atmService.class);
		
		
		boolean status = atmService.CheckCredentials(user);
		
		
		if(status) {
			HttpSession session = req.getSession();
			session.setAttribute("User", user);
			
			modelAndView = new ModelAndView("LoginSuccess.jsp");
			
			
		}
		else {
			modelAndView = new ModelAndView("LoginFailed.jsp");
			
		}
		return modelAndView;
	}*/
		
}
