package it.engineering.webapp.action.manufacturer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.City;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.CityServiceImpl;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;
import it.engineering.webapp.validator.ManufacturerValidator;

public class ManufacturerAddAction extends AbstractAction{

	private CityServiceImpl cityService;
	private ManufacturerServiceImpl manufacturerService;
	private ManufacturerValidator manufacturerValidator;
	
	public ManufacturerAddAction() {
		cityService =new CityServiceImpl();
		manufacturerService = new ManufacturerServiceImpl();
		manufacturerValidator = new ManufacturerValidator();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Manufacturer manufacturer = new Manufacturer();
		String pib = request.getParameter("pib");
		String cid = request.getParameter("cid");
		String address = request.getParameter("address");
		City city = cityService.find(Long.parseLong(request.getParameter("city"))).orElse(null);
		
		manufacturer.setCity(city);
		manufacturer.setAddress(address);
		manufacturer.setCid(cid);
		manufacturer.setPib(pib);
		
		List<String> errors = manufacturerValidator.validate(manufacturer);
		
		if(!errors.isEmpty()) {
			
			request.setAttribute("manufacturers", manufacturerService.findAll());
			request.setAttribute("cities", cityService.findAll());
			request.setAttribute("errors",errors);
			request.setAttribute("manufacturer", manufacturer);
			return WebConstant.PAGE_HOME;
		}
		
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_ADD;
	}

}
