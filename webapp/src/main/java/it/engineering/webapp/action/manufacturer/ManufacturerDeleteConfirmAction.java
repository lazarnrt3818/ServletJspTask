package it.engineering.webapp.action.manufacturer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.CityServiceImpl;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class ManufacturerDeleteConfirmAction extends AbstractAction{

	private ManufacturerServiceImpl manufacturerService;
	private CityServiceImpl cityService;

	public ManufacturerDeleteConfirmAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
		this.cityService = new CityServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO DELETE manufacturer
		if(request.getParameter("option").equalsIgnoreCase("Delete")) {
			manufacturerService.remove(Long.parseLong(request.getParameter("id")));
		}
		request.setAttribute("manufacturers", manufacturerService.findAll());
		request.setAttribute("cities", cityService.findAll());
		return WebConstant.PAGE_HOME;
	
	}

}
