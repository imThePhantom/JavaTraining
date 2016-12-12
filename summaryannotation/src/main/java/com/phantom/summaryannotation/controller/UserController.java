package com.phantom.summaryannotation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phantom.summaryannotation.constant.Role;
import com.phantom.summaryannotation.dao.UserDAO;
import com.phantom.summaryannotation.model.User;
import com.phantom.summaryannotation.validation.UserValidate;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserValidate userValidator;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	public String user(Model model, Locale locale, RedirectAttributes redirectAttr) {
		model.addAttribute("title", messageSource.getMessage("user.title", null, locale));

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User loggedUser = userDAO.findUserByEmail(email);

		if (loggedUser.getsPIN() == null) {
			redirectAttr.addFlashAttribute("message",
					messageSource.getMessage("message.spin.notset", null, locale));
			return "redirect:user/change-pin";
		}

		model.addAttribute("user", loggedUser);

		return "/user/user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String user(Model model, Locale locale, @ModelAttribute(value = "user") User user,
			BindingResult result) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User loggedUser = userDAO.findUserByEmail(email);

		userValidator.usernameValidate(user, result);
		if (result.hasErrors()) {
			model.addAttribute("error",
					messageSource.getMessage("error.username.empty", null, locale));
			model.addAttribute("user", loggedUser);
			return "user/user";
		}

		if (loggedUser.getUsername().equals(user.getUsername())) {
			model.addAttribute("error",
					messageSource.getMessage("error.username.same", null, locale));
			model.addAttribute("user", loggedUser);
			return "user/user";
		}

		loggedUser.setUsername(user.getUsername());
		userDAO.updateUser(loggedUser);

		model.addAttribute("user", loggedUser);
		return "/user/user";
	}

	@RequestMapping(value = "/change-pin", method = RequestMethod.GET)
	public String updatePin(Model model, Locale locale) {
		model.addAttribute("title", messageSource.getMessage("pin.update.title", null, locale));

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User loggedInUser = userDAO.findUserByEmail(email);

		if (loggedInUser.getsPIN() == null) {
			model.addAttribute("updateMode", "newPin");
		} else {
			model.addAttribute("updateMode", "updatePin");
		}

		return "/user/change-pin";
	}

	@RequestMapping(value = "/change-pin", method = RequestMethod.POST)
	public String updatePin(Model model, Locale locale, RedirectAttributes redirectAttr,
			@RequestParam(value = "curPin", required = false) String curPin,
			@RequestParam("newPin") String newPin) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDAO.findUserByEmail(email);

		if (!userValidator.sPinValidate(newPin)) {
			model.addAttribute("newPinError",
					messageSource.getMessage("error.pin.invalid.newpin", null, locale));
			return "/user/change-pin";
		}

		if (user.getsPIN() != null) {
			model.addAttribute("updateMode", "updatePin");
			if (curPin != null && !userValidator.sPinValidate(curPin)) {
				model.addAttribute("curPinError",
						messageSource.getMessage("error.pin.invalid.curpin", null, locale));
				return "/user/change-pin";
			}

			if (!user.getsPIN().equals(curPin)) {
				model.addAttribute("curPinError",
						messageSource.getMessage("error.pin.invalid.curpin", null, locale));
				return "/user/change-pin";
			}

			if (curPin.equals(newPin)) {
				model.addAttribute("error",
						messageSource.getMessage("error.pin.same", null, locale));
				return "/user/change-pin";
			}

		}

		user.setsPIN(newPin);
		userDAO.updateUser(user);

		redirectAttr.addFlashAttribute("message",
				messageSource.getMessage("message.pin.changesuccess", null, locale));

		return "redirect:/user";
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.GET)
	public String changePassword(Model model, Locale locale) {
		model.addAttribute("title",
				messageSource.getMessage("password.change.title", null, locale));

		return "/user/change-password";
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(Model model, Locale locale, RedirectAttributes redirectAttr,
			@RequestParam(value = "curPass", required = false) String curPass,
			@RequestParam("newPass") String newPass) {

		if (userValidator.passwordValidate(curPass)) {
			model.addAttribute("curPassError",
					messageSource.getMessage("error.password.invalid", null, locale));
			return "/user/change-password";
		}
		;

		if (userValidator.passwordValidate(newPass)) {
			model.addAttribute("newPassError",
					messageSource.getMessage("error.password.invalid", null, locale));
			return "/user/change-password";
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User loggedUser = userDAO.findUserByEmail(email);

		if (!passwordEncoder.matches(curPass, loggedUser.getPassword())) {
			model.addAttribute("curPassError",
					messageSource.getMessage("error.password.invalid.curpass", null, locale));
			return "/user/change-password";
		}

		if (curPass.equals(newPass)) {
			model.addAttribute("curPassError",
					messageSource.getMessage("error.password.same", null, locale));
			return "/user/change-password";
		}

		loggedUser.setPassword(newPass);

		if (loggedUser.getRole().equals(Role.INACTIVE_USER)) {
			loggedUser.setRole(Role.USER);

			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.USER));
			Authentication newAuth = new UsernamePasswordAuthenticationToken(loggedUser.getEmail(),
					auth.getCredentials(), authorities);
			SecurityContextHolder.getContext().setAuthentication(newAuth);
		}

		userDAO.changePassword(loggedUser);

		redirectAttr.addFlashAttribute("message",
				messageSource.getMessage("message.password.changesuccess", null, locale));

		return "redirect:/user";
	}

	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String updateUserInfo() {

		return "/user/setting";
	}

	@RequestMapping(value = "/user-history", method = RequestMethod.GET)
	public String userHistory() {

		return "/user/update-info";
	}
}