package it.engineering.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

	@PostMapping("/add")
	public ModelAndView postManufacturerAdd() {
		
		ModelAndView modelAndView = new ModelAndView("");
		
		
		return null;
	}
}
