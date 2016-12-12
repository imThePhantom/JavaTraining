package com.phantom.summaryannotation.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.phantom.summaryannotation.constant.Constant;
import com.phantom.summaryannotation.model.User;

public class UserValidate implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors result) {
		User user = (User) target;
		user.setUsername(user.getUsername().trim());

		emailValidate(user.getEmail(), result);
		passwordValidate(user.getPassword(), result);
		usernameValidate(user, result);
	}

	public void resetFormvalidate(Object target, Errors result) {
		User user = (User) target;

		emailValidate(user.getEmail(), result);
		sPinValidate(user.getsPIN(), result);
	}

	private void emailValidate(String email, Errors result) {
		if (!Constant.EMAIL_PATTERN.matcher(email).matches()) {
			result.rejectValue("email", "error.email.invalid");
		}
	}

	private void passwordValidate(String password, Errors result) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "password", "error.password.invalid");

		if (password.contains(" ")) {
			result.rejectValue("password", "error.password.containspace");
		}
		if (password.length() > 0 && password.length() < Constant.PASSWORD_MINIMUM_LENGTH) {
			result.rejectValue("password", "error.password.tooshort");
		}
	}

	private void sPinValidate(String sPin, Errors result) {
		if (!Constant.NUMBER_PATTEN.matcher(sPin).matches() || sPin.length() != 6) {
			result.rejectValue("sPIN", "error.pin.invalid");
		}
	}

	public void usernameValidate(User user, Errors result) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "username", "error.username.empty");
	}

	public boolean passwordValidate(String password) {
		return (password.contains(" ") || password.length() < Constant.PASSWORD_MINIMUM_LENGTH);
	}
	
	public boolean sPinValidate(String sPin) {
		return (Constant.NUMBER_PATTEN.matcher(sPin).matches() && sPin.length() == 6);
	}

}
