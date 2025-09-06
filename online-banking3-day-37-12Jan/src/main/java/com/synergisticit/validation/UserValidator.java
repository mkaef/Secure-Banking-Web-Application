package com.synergisticit.validation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.domain.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "user.username.empty", "User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty","userId should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "user.password.empty", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "user.email.empty", "Email is required.");
		
		if(user.getRoles().isEmpty()) {
			errors.rejectValue("roles", "user.roles.empty", "You did not select any role.");
		}
		
		

	}
		
	}

	
	

