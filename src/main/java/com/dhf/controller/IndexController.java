package com.dhf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhf.model.User;
import com.dhf.model.UserException;
import com.dhf.service.IUserService;

@Controller
public class IndexController {
	@Autowired
 private IUserService userService;

public IUserService getUserServices() {
	return userService;
}

public void setUserServices(IUserService userService) {
	this.userService = userService;
}

@RequestMapping("/")
 public String index(){
	 return "login";
 }

@RequestMapping(value="/login", method = RequestMethod.POST)
public String login(User user,HttpSession session) throws UserException{
	User loginUser=userService.login(user);
	session.setAttribute("loginUser", loginUser);
	return "redirect:/user/list";
}
}
