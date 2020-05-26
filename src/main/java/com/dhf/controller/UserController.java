package com.dhf.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhf.model.User;
import com.dhf.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
private IUserService userService;

	public IUserService getUservice() {
		return userService;
	}

	public void setUservice(IUserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/list")
	public String list(Model model,HttpSession session){
		model.addAttribute("users",userService.list());
		return "user/list";
	}
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(Model model){
		User user=new User();
		System.out.print(user);
		model.addAttribute("user",user);
		return "user/add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated User user){
         System.out.print(user);
		userService.add(user);
		return "redirect:/user/list";
	}
	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String add(@Validated User user, BindingResult bindingResult) {
	 if (bindingResult.hasErrors()) {
	 return "user/add";
	 }
	 // 操作数据库添加
	 userService.add(user);
	 return "redirect:/user/list";
}*/
	@RequestMapping("/delete")
	public String delete(int id){
		userService.remove(id);
		return "redirect:/user/list";
	}
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(User user,Model model){
		model.addAttribute("user",user);
		return "/user/update";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Validated User user){
		userService.update(user);
		return "redirect:/user/list";
	}
}
