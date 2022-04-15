package it.engineering.webapp.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.service.impl.CityServiceImpl;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class HomeGetAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;
	private CityServiceImpl cityService;

	public HomeGetAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
		this.cityService = new CityServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", manufacturerService.findAll());
		request.setAttribute("cities", cityService.findAll());
		return WebConstant.PAGE_HOME;
	}

}
