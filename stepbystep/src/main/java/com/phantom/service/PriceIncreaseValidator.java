package com.phantom.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.phantom.model.PriceIncrease;

public class PriceIncreaseValidator implements Validator {
	private int DEFAULT_MIN_PERCENTAGE = 5;
	private int DEFAULT_MAX_PERCENTAGE = 100;

	private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

	protected Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean supports(Class<?> arg0) {
		return PriceIncrease.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PriceIncrease pi = (PriceIncrease) obj;
		if (pi == null) {
			errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
		} else {
			logger.info("Validating with " + pi + " : " + pi.getPercentage());
			if (pi.getPercentage() > maxPercentage) {
				errors.rejectValue("percentage", "error.too-high",
						new Object[] { new Integer(maxPercentage) }, "Value too high.");
				logger.info("Value too hight");
			}
			if (pi.getPercentage() <= minPercentage) {
				errors.rejectValue("percentage", "error.too-low",
						new Object[] { new Integer(minPercentage) }, "Value too low.");
				logger.info("Value too low");
			}
		}
	}

	public int getMinPercentage() {
		return minPercentage;
	}

	public void setMinPercentage(int minPercentage) {
		this.minPercentage = minPercentage;
	}

	public int getMaxPercentage() {
		return maxPercentage;
	}

	public void setMaxPercentage(int maxPercentage) {
		this.maxPercentage = maxPercentage;
	}

}
