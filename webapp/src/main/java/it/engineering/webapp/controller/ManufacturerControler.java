package it.engineering.webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.engineering.webapp.domain.dto.ManufacturerDto;
import it.engineering.webapp.service.CityService;
import it.engineering.webapp.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerControler {

	@Autowired
	private CityService cityService;

	@Autowired
	private ManufacturerService manufacturerService;

	@PostMapping("/add")
	public ModelAndView addManufacturer(
			@Valid @ModelAttribute("manufacturer") 
			ManufacturerDto manufacturer,
			BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView("manufacturer/add-confirm-manufacturer");
		
		System.out.println(bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("home/home");
			modelAndView.addObject("cities",cityService.findAll());
			modelAndView.addObject("manufacturers",manufacturerService.findAll());
		} else {
			modelAndView.setViewName("manufacturer/add-confirm-manufacturer");
			modelAndView.addObject("manufacturer", manufacturer);
		}


		return modelAndView;
	}
	
	
	@PostMapping("/add/confirm")
	public ModelAndView confirmAddManufacturer(@Valid@ModelAttribute("manufacturer") ManufacturerDto manufacturer,BindingResult bindingResult) {
		System.out.println("CONFIRM : " + manufacturer);
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		manufacturerService.save(manufacturer);
		return modelAndView;
	}
	
	@GetMapping("/edit")
	public ModelAndView editManufacturer(@RequestParam("id") String pib) {
		ModelAndView modelAndView = new ModelAndView("manufacturer/edit-manufacturer");
		
		modelAndView.addObject("manufacturer",manufacturerService.find(Long.parseLong(pib)).get());
		modelAndView.addObject("cities",cityService.findAll());
		
		System.out.println("ID: "+ pib);
		System.out.println(manufacturerService.find(Long.parseLong(pib)).get());
		
		return modelAndView;
	}
	
	@PostMapping("/edit/confirm")
	public ModelAndView editConfirmManufacturer(@ModelAttribute("manufacturer") ManufacturerDto manufacturer,@RequestParam String option) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		
		
		System.out.println("Option : "+ option);
		
		System.out.println("edit-confirm: " + manufacturer);
		
		if(option.equalsIgnoreCase("edit")) {
			manufacturerService.update(manufacturer);
		}
		
		return modelAndView;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteManufacturer(@RequestParam("id") String pib) {
		ModelAndView modelAndView = new ModelAndView("manufacturer/delete-manufacturer");
		
		modelAndView.addObject("manufacturer",manufacturerService.find(Long.parseLong(pib)).get());
		
		return modelAndView;
	}
	
	@PostMapping("/delete/confirm")
	public ModelAndView deleteConfirmManufacturer(@RequestParam("id") String pib,@RequestParam String option) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		
		if(option.equalsIgnoreCase("Delete"))
			manufacturerService.remove(Long.parseLong(pib));
		
		
		return modelAndView;
	}
	
	
//	@ModelAttribute(name = "manufacturer")
//	public ManufacturerDto manufacturerDtoModelAttribute() {
//		return new ManufacturerDto();
//	}

//	@InitBinder
//	public void initBinder(DataBinder dataBinder) {
//		if (dataBinder.getTarget() instanceof ManufacturerDto) {
//			System.out.println("INIT BINDER");
//			dataBinder.addValidators(validator);
//		}
//	}
//	@ModelAttribute
//	public ManufacturerDto modelManufacturerDto() {
//		return new ManufacturerDto();
//	}
}
