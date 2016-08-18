package com.gestion.pilotage.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";

	/**
	 * Validate hex with regular expression.
	 * 
	 * @param email
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validateEmail(final String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);

		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * ( # Start of group (?=.*\d) # must contains one digit from 0-9
	 * (?=.*[a-z]) # must contains one lowercase characters (?=.*[A-Z]) # must
	 * contains one uppercase characters (?=.*[@#$%]) # must contains one
	 * special symbols in the list "@#$%" . # match anything with previous
	 * condition checking {6,20} # length at least 6 characters and maximum of
	 * 20 ) # End of group
	 * 
	 * @param password
	 *            the password.
	 * @return valid or not.
	 */
	public static boolean validatePassword(final String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
