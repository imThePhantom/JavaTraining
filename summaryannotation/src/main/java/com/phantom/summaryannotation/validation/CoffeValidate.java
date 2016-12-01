package com.phantom.summaryannotation.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.phantom.summaryannotation.model.Coffee;

public class CoffeValidate implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Coffee.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors result) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "coffeeCode", "Code is required");
		ValidationUtils.rejectIfEmpty(result, "name", "Name is required");
		ValidationUtils.rejectIfEmpty(result, "price", "Price is required");
	}
}
