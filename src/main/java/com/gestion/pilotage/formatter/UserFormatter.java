package com.gestion.pilotage.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;

import com.gestion.pilotage.model.User;
import com.gestion.pilotage.service.UserService;

/**
 * Conversion user ASP ou Java en objet de la base de données.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public class UserFormatter implements Formatter<User> {

	@Autowired(required = true)
	@Qualifier(value = "userService")
	private UserService userService;

	@Override
	public String print(User object, Locale locale) {
		return Integer.toString(object.getId());
	}

	@Override
	public User parse(String text, Locale locale)
			throws java.text.ParseException {
		int id = Integer.parseInt(text);
		return userService.findUserById(id);
	}
}