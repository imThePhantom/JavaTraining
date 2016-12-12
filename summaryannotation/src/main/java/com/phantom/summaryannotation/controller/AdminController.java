package com.phantom.summaryannotation.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phantom.summaryannotation.dao.CoffeeDAO;
import com.phantom.summaryannotation.model.Coffee;
import com.phantom.summaryannotation.validation.CoffeeValidate;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private CoffeeValidate coffeeValidate;
	@Autowired
	private CoffeeDAO coffeeDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("admin.title", null, locale));
				
		return "admin/admin";
	}

	@RequestMapping(value = "/add-coffee", method = RequestMethod.GET)
	public String addCoffee(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("coffee.add.title", null, locale));

		Coffee coffee = new Coffee();
		model.addAttribute("coffee", coffee);

		return "/admin/add-coffee";
	}

	@RequestMapping(value = "/add-coffee", method = RequestMethod.POST)
	public String addCoffee(Model model, Locale locale, RedirectAttributes redirectAttr,
			@ModelAttribute("coffee") Coffee coffee, BindingResult result) {
		coffeeValidate.validate(coffee, result);
		if (result.hasErrors()) {
			return "/admin/add-coffee";
		}
		
		Coffee newCoffee = coffeeDAO.findCoffeeByCode(coffee.getCoffeeCode());
		if (newCoffee != null) {
			model.addAttribute("error", messageSource.getMessage("error.coffee.existed", null, locale));
			return "admin/add-coffee";
		}
		
		newCoffee = coffee;
		newCoffee.setEnabled(true);
		
		coffeeDAO.addCoffee(newCoffee);
		
		return "redirect:/admin";
	}

	@RequestMapping("/admin/edit-coffee")
	public String updateCoffeePrice() {

		return "/admin/edit-coffee";
	}

	@RequestMapping("/admin/manage-user")
	public String editUser() {

		return "/admin/managee-user";
	}

	@RequestMapping("/admin/update-user")
	public String deleteUser() {

		return "/admin/update-user";
	}

	@RequestMapping("/admin/daily-report")
	public String reportByDate() {

		return "/admin/daily-report";
	}

	@RequestMapping("/admin/statistic")
	public void statistic() {

	}
}
