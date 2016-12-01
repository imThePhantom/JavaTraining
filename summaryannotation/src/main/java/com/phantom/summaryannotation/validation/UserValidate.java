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
	public void validate(Object target, Errors results) {
		User user = (User) target;
		if (!Constant.EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
			results.rejectValue("email", "error.email.invalid");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(results, "password", "error.password.invalid");
		if (user.getPassword().length() > 0 && user.getPassword().length() < Constant.PASSWORD_MINIMUM_LENGTH) {
			results.rejectValue("password", "error.password.tooshort");
		}

		ValidationUtils.rejectIfEmpty(results, "username", "error.username.empty");
	}

	public void resetFormvalidate(Object target, Errors result) {
		User user = (User) target;

		if (!Constant.EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
			result.rejectValue("email", "error.email.invalid");
		}

		if (!Constant.NUMBER_PATTEN.matcher(user.getsPIN()).matches() || user.getsPIN().length() != 6) {
			result.rejectValue("sPIN", "error.pin.invalid");
		}
	}
}
