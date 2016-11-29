package com.phantom.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.phantom.model.Product;

public class ProductValidator implements Validator{
	
	protected Log logger = LogFactory.getLog(getClass());
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Product.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {
		Product product = (Product) obj;
		if (product == null) {
			error.reject("product is null");
		} else {
			logger.info("Validating product: " + product.getName());
			if (product.getName().isEmpty()) {
				error.rejectValue("name", "required", null, "Name is required");
			}
			if (product.getPrice().isNaN() || product.getPrice() <= 0) {
				error.rejectValue("price", "required", null, "Invalid price");
			}
		}
	}

}
