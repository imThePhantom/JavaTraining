package com.phantom.summaryannotation.validation;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.phantom.summaryannotation.model.Coffee;

public class CoffeeValidate implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Coffee.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors result) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "coffeeCode", "coffee.name.required");
		ValidationUtils.rejectIfEmpty(result, "name", "coffee.name.required");
		ValidationUtils.rejectIfEmpty(result, "price", "coffee.price.required");
		
		Coffee coffee = (Coffee) target;
		if (coffee.getPrice().compareTo(BigDecimal.ZERO) <0) {
			result.rejectValue("price", "coffee.price.invalid");
		}
	}
}
