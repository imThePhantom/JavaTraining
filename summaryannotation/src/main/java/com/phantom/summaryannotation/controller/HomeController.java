package com.phantom.summaryannotation.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phantom.summaryannotation.constant.Constant;
import com.phantom.summaryannotation.constant.Role;
import com.phantom.summaryannotation.dao.UserDAO;
import com.phantom.summaryannotation.model.User;
import com.phantom.summaryannotation.validation.UserValidate;

@Controller
public class HomeController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserValidate userValidator;
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = { "", "home" }, method = RequestMethod.GET)
	public String homePage(Model model, Locale locale) {

		model.addAttribute("title", messageSource.getMessage("home.title", null, locale));
		model.addAttribute("greeting", messageSource.getMessage("greeting", null, locale));

		return "home";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model, Locale locale,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		model.addAttribute("title", messageSource.getMessage("login.title", null, locale));

		if (error != null) {
			model.addAttribute("error",
					messageSource.getMessage("error.invalid.login", null, locale));
		}

		if (logout != null) {
			model.addAttribute("message", messageSource.getMessage("message.logout", null, locale));
		}

		return "home/login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("register.title", null, locale));

		User user = new User();
		model.addAttribute("user", user);

		return "home/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String actionRegister(@ModelAttribute("user") User user, BindingResult result,
			Model model, Locale locale) {
		userValidator.validate(user, result);
		System.out.println("User validated");

		if (result.hasErrors()) {
			return "home/register";
		}

		if (userDAO.findUserByEmail(user.getEmail()) != null) {
			model.addAttribute("error",
					messageSource.getMessage("error.email.existing", null, locale));
			return "home/register";
		}

		user.setEnabled(true);
		user.setRole(Role.USER);
		System.out.println("Start create user");
		userDAO.addUser(user);

		model.addAttribute("message",
				messageSource.getMessage("message.register.completed", null, locale));
		return "redirect:home";
	}

	@RequestMapping(value = "reset-password", method = RequestMethod.GET)
	public String resetPassword(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("reset.password.title", null, locale));

		User user = new User();
		model.addAttribute("user", user);

		return "home/reset-password";
	}

	@RequestMapping(value = "reset-password", method = RequestMethod.POST)
	public String actionResetPassword(@ModelAttribute("user") User user, BindingResult result,
			Model model, Locale locale) {
		userValidator.resetFormvalidate(user, result);
		if (result.hasErrors()) {
			return "home/reset-password";
		}

		User resetUser = userDAO.findUserByEmail(user.getEmail());
		if (resetUser == null || !resetUser.getsPIN().equals(user.getsPIN())) {
			model.addAttribute("error",
					messageSource.getMessage("error.resetform", null, locale));
			return "home/reset-password";
		}

		String newPassword = new BigInteger(60, new SecureRandom()).toString(12);
		resetUser.setPassword(newPassword);
		resetUser.setRole(Role.INACTIVE_USER);;
		userDAO.changePassword(resetUser);
		model.addAttribute("message",
				messageSource.getMessage("message.newpassword", null, locale) + newPassword);
		
		return "home/reset-password";
	}

	@RequestMapping(value = "403", method = RequestMethod.GET)
	private String accessDenied() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			System.out.println(userDetails);
		}
		return "home/403";
	}

	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String init() {
		return "home/init";
	}

	@RequestMapping(value = "init", params = { "init" }, method = RequestMethod.POST)
	public String initAdmin() {
		System.out.println("\n\nInit admin and default guest user");

		User admin;
		admin = userDAO.findUserByEmail("admin@springmvc.com");
		if (admin == null) {
			admin = new User();
			admin.setEmail("admin@springmvc.com");
			admin.setUsername("admin");
			admin.setPassword("admin@admin");
			admin.setEnabled(true);
			admin.setRole(Role.ADMIN);
			userDAO.addUser(admin);
		}

		User guest;
		guest = userDAO.findUserByEmail(Constant.GUEST_EMAIL);
		if (guest == null) {
			guest = new User();
			guest.setEmail(Constant.GUEST_EMAIL);
			guest.setUsername(Constant.GUEST_USERNAME);
			guest.setPassword(Constant.GUEST_PASSWORD);
			guest.setEnabled(true);
			guest.setRole(Constant.GUEST_ROLE);

			userDAO.addUser(guest);
		}

		System.out.println(admin);
		System.out.println(guest);
		return "redirect:home";
	}

}
