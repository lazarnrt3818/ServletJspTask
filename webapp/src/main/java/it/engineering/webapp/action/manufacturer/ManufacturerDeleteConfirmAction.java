package it.engineering.webapp.action.manufacturer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class ManufacturerDeleteConfirmAction extends AbstractAction{

	private ManufacturerServiceImpl manufacturerService;

	public ManufacturerDeleteConfirmAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO DELETE manufacturer
		CityRepository cityRepo = new CityRepository();
		if(request.getParameter("option").equalsIgnoreCase("Delete")) {
			manufacturerService.remove(Long.parseLong(request.getParameter("id")));
		}
		request.setAttribute("manufacturers", manufacturerService.findAll());
		request.setAttribute("cities", cityRepo.getAll());
		return WebConstant.PAGE_HOME;
	
	}

}
