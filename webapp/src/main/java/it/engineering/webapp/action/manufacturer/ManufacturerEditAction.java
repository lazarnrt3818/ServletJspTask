package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.City;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class ManufacturerEditAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;

	public ManufacturerEditAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CityRepository cityRepo = new CityRepository();
		Long id = Long.parseLong(request.getParameter("id"));
		Manufacturer manufacturer = manufacturerService.find(id).orElse(null);

		for (City c : cityRepo.getAll()) {
			System.out.println(c.getName());
		}
		request.setAttribute("cities", cityRepo.getAll());
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_EDIT;

	}

}
