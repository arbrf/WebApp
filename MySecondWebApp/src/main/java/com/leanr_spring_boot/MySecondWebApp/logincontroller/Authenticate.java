package com.leanr_spring_boot.MySecondWebApp.logincontroller;

import org.springframework.stereotype.Component;

@Component
public class Authenticate {
  public boolean isAuthenticate(String username,String password) {
	  
	  boolean isuserNameValid=username.equals("in28minutes");
	  boolean ispasswordValid=password.equals("dummy");
	  
	  return ispasswordValid && isuserNameValid; 
  }
}
