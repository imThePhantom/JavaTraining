package com.phantom.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PriceIncrease {
	protected final Log logger = LogFactory.getLog(getClass());
	
	private int percentage;
	
	public void setPercentage(int perc) {
		percentage = perc;
		logger.info("Percentage set to " + perc);
	}
	
	public int getPercentage() {
		return percentage;
	}
}
