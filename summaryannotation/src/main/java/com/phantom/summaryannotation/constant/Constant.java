package com.phantom.summaryannotation.constant;

import java.util.regex.Pattern;

public class Constant {

	public static final int COFFEE_CODE_MINIMUM_LENGTH = 5;
	public static final int PASSWORD_MINIMUM_LENGTH = 6;
	public static final int PIN_LENGTH = 6;
	public static final String GUEST_EMAIL = "guest@springmvc.com";
	public static final String GUEST_USERNAME = "guest";
	public static final String GUEST_PASSWORD = "guest";
	public static final String GUEST_ROLE = Role.GUEST;
	public static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	public static final Pattern NUMBER_PATTEN = Pattern.compile("^[0-9]+$");
}
