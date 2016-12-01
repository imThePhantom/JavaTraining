package com.phantom.summaryannotation.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("user.title", null, locale));
		
		return "user/user";
	}
	
	@RequestMapping("/update-info")
	public String updateUserInfo() {
		
		return "user/update-info";
	}
	
	@RequestMapping("/change-password")
	public String changePassword() {
		
		return "user/update-info";
	}

	@RequestMapping("/user-history")
	public String userHistory() {
		
		return "user/update-info";
	}
	
	@RequestMapping("/deactive")
	public String deactive() {
		
		return "user/update-info";
	}
	
}
