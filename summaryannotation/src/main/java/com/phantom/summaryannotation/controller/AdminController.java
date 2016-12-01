package com.phantom.summaryannotation.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("admin.title", null, locale));

		return "admin/admin";
	}
	
	@RequestMapping("/add-coffee")
	public String addCoffee() {
		
		return "add-coffee";
	}
	
	@RequestMapping("/edit-coffee")
	public String updateCoffeePrice() {
		
		return "";
	}

	@RequestMapping("/manage-user")
	public String editUser() {
		
		return "";
	}
	
	@RequestMapping("/update-user")
	public String deleteUser() {
		
		return "";
	}
	
	@RequestMapping("/daily-report")
	public String reportByDate() {
		
		return "";
	}
	
	@RequestMapping("/statistic")
	public void statistic() {
		
	}
}
