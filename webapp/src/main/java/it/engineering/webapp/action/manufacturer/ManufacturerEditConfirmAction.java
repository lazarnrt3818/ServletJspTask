package it.engineering.webapp.action.manufacturer;

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

public class ManufacturerEditConfirmAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;
	private CityServiceImpl cityService;

	public ManufacturerEditConfirmAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
		this.cityService = new CityServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("option").equalsIgnoreCase("Edit")) {
			Manufacturer manufacturer = new Manufacturer();
			
			manufacturer.setAddress(request.getParameter("address"));
			manufacturer.setCid(request.getParameter("cid"));
			manufacturer.setPib(request.getParameter("pib"));
			manufacturer.setId(Long.parseLong(request.getParameter("id")));
			City city = cityService.find(Long.parseLong(request.getParameter("city"))).orElse(null);
			manufacturer.setCity(city);
			
			manufacturerService.update(manufacturer);
		}
		request.setAttribute("cities", cityService.findAll());
		request.setAttribute("manufacturers", manufacturerService.findAll());
		return WebConstant.PAGE_HOME;
	}

}
