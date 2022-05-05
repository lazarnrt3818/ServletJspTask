package it.engineering.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.engineering.webapp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getLogin() {
		return "login/login";
	}
	
	
	@PostMapping
	public ModelAndView postLogin(@RequestParam String username, @RequestParam String password) {

		ModelAndView modelAndView = new ModelAndView("login/login");

		System.out.println("Test");
		if (userService.login(username, password) != null) {
			
			modelAndView.setViewName("redirect:/home");
		
		} else {
		
			modelAndView.addObject("information", "Invalid credentials");
		}

		return modelAndView;
	}
}
