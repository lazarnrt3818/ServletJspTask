package it.engineering.webapp.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class HomeGetAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;

	public HomeGetAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", manufacturerService.findAll());
		return WebConstant.PAGE_HOME;
	}

}
