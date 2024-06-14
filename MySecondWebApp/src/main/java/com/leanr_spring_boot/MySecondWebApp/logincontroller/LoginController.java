package com.leanr_spring_boot.MySecondWebApp.logincontroller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
	@Autowired
	private Authenticate authenticate;
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String welcome(@RequestParam String name,@RequestParam String password,ModelMap model) {
		 boolean authentication=authenticate.isAuthenticate(name,password);
		 if(authentication) {
		model.put("password", password);
		
		model.put("name", name);
		return "welcome";
		 }
		 else {
			 model.put("error", "Invalid credentials please try again");
			return "login";
		}
	}
	
}