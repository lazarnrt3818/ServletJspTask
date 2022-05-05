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

public class ManufacturerEditAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;
	private CityServiceImpl cityService;

	public ManufacturerEditAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
		this.cityService = new CityServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		ManufacturerEntity manufacturer = manufacturerService.find(id).orElse(null);

		request.setAttribute("cities", cityService.findAll());
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_EDIT;

	}

}
