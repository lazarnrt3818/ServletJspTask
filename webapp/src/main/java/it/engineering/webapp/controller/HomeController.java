package it.engineering.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.engineering.webapp.domain.dto.ManufacturerDto;
import it.engineering.webapp.service.CityService;
import it.engineering.webapp.service.ManufacturerService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private CityService cityService;
	
	
	
	@GetMapping
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView("home/home");
		
		List<ManufacturerDto> manufacturers = manufacturerService.findAll();
		
		modelAndView.addObject("manufacturers",manufacturers);
		modelAndView.addObject("cities",cityService.findAll());
		
		modelAndView.addObject("manufacturer",new ManufacturerDto());
		
		
		return modelAndView;
	}
	
	

	
//	@ModelAttribute
//	public ManufacturerDto manufacturerDto() {
//		return new ManufacturerDto();
//	}
}
