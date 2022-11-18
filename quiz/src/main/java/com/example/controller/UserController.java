package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Authority;
import com.example.domain.User;
import com.example.service.AuthorityService;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthorityService authorityService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegister(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult
		,RedirectAttributes redirectAttributes) {
		model.addAttribute("user", user);
		if (userService.getUserByUsername(user.getUsername()) != null) {
			String rs = "USER ALREADY EXISTS, CHOOSE DIFFERENT USER NAME!";
			model.addAttribute("rs", rs);
			return "register";
		}

		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getUserPassword());
		user.setUserPassword(encodedPassword);
		userService.save(user);
		
		Authority auth = new Authority();
		auth.setAuthority("ROLE_USER");
		auth.setUsername(user.getUsername());
		authorityService.save(auth);
		
		String rs = "User is registered successfully, please login.";
		redirectAttributes.addFlashAttribute("rs", rs);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/admin/manage-users", method = RequestMethod.GET)
	public String manageUser(Model model) {
		Iterable<User> userIter = userService.findAll();
		List<User> userList = new ArrayList<>();
		for (User u : userIter) {
			userList.add(u);
		}
		model.addAttribute("userList", userList);
		return "manage-users";
	}
	
	
	@RequestMapping(value = "/admin/delete-user", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") long id) {
		userService.deleteById(id);
		return "redirect:/admin/manage-users";
	}
	
	@RequestMapping(value = "/admin/disable-user", method = RequestMethod.GET)
	public String disableUser(@RequestParam("id") long id) {
		User user = userService.findById(id).get();
		boolean status = user.isEnabled();
		System.out.println(user.toString() + " " + status);
		if (status) {
			user.setEnabled(false);
		} else {
			user.setEnabled(true);
		}
		userService.save(user);
		System.out.println(user.toString() + " " + status);
		return "redirect:/admin/manage-users";		
	}
	
}
