package it.finsoft.winebook.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.finsoft.winebook.model.User;
import it.finsoft.winebook.model.Wine;
import it.finsoft.winebook.validator.UserValidator;

@Controller
public class WineController {
	List<User> userList = new ArrayList<>();

	public List<User> getUserList() {
		return userList;
	}

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	//@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@PostMapping("/registration")
	//@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/registration";
		}
		model.addAttribute("user_info", userForm.getUsername());
		userList.add(userForm);
		return "/reservation";
	}

	@RequestMapping(value = { "/reservation" }, method = RequestMethod.POST)
	public String welcome(Model model, @RequestParam("pinkk") int pink, @RequestParam("whitee") int white,
			@RequestParam("redd") int red, @RequestParam("user_name") String user_name )

	{

		Wine w1 = new Wine("Red wine", 0,0,0,0);
		Wine w2 = new Wine("Pink wine",  0,0,0,0);
		Wine w3 = new Wine("White wine",  0,0,0,0);
		int a = 0;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(user_name)) {
				a = i;
			}
		}
		userList.get(a).setWines(Arrays.asList(w1, w2, w3));
		model.addAttribute("userList", userList);
		return "/welcome";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {

		return "/welcome";
	}

}
