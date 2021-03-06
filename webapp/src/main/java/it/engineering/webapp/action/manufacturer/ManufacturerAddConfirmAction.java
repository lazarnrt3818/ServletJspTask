package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.CityEntity;
import it.engineering.webapp.domain.ManufacturerEntity;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.CityServiceImpl;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class ManufacturerAddConfirmAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;
	private CityServiceImpl cityService;
	
	public ManufacturerAddConfirmAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
		cityService = new CityServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		ManufacturerEntity manufacturer = new ManufacturerEntity();
		if (request.getParameter("option").equalsIgnoreCase("confirm")) {
			manufacturer.setAddress(request.getParameter("address"));
			manufacturer.setCid(request.getParameter("cid"));
			manufacturer.setPib(request.getParameter("pib"));
			CityEntity city = cityService.find(Long.parseLong(request.getParameter("city"))).orElse(null);
			manufacturer.setCity(city);

			manufacturerService.save(manufacturer);
		}

		request.setAttribute("manufacturers", manufacturerService.findAll());
		request.setAttribute("cities", cityService.findAll());
		return WebConstant.PAGE_HOME;
	}

}
