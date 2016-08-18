package com.gestion.pilotage.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gestion.pilotage.model.User;

public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		
		if(user.getEmail() == null){
			errors.rejectValue("email", "Pattern.userForm.email");
		}
	}

}
