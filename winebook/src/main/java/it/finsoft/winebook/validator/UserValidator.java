package it.finsoft.winebook.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.finsoft.winebook.controller.WineController;
import it.finsoft.winebook.model.User;

@Component
public class UserValidator implements Validator {

	@Autowired
	private WineController winecontrol;

	// List<User> usrLst = winecontrol.getList();
	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

		List<User> userlist = winecontrol.getUserList();
		User user = (User) o;
		// USERNAME
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 3 || user.getUsername().length() > 10) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userlist.contains(user)) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		// NAME
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		if (user.getName().length() < 1 || user.getName().length() > 10) {
			errors.rejectValue("name", "Size.userForm.name");
		}

		// NAME
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");

		// BIRTHDATE
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "NotEmpty");
		if (user.getBirthdate() < 18) {
			errors.rejectValue("birthdate", "Size.userForm.birthdate");
		}

		// EMAIL
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		if (userlist.contains(user)) {
			errors.rejectValue("email", "Duplicate.userForm.email");
		}

	}
}