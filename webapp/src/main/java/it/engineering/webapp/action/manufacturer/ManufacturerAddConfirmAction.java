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

public class ManufacturerAddConfirmAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;

	public ManufacturerAddConfirmAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		CityRepository cityRepo = new CityRepository();
		Manufacturer manufacturer = new Manufacturer();
		if (request.getParameter("option").equalsIgnoreCase("confirm")) {
			manufacturer.setAddress(request.getParameter("address"));
			manufacturer.setCid(request.getParameter("cid"));
			manufacturer.setPib(request.getParameter("pib"));
			City city = cityRepo.getById(Long.parseLong(request.getParameter("city"))).orElse(null);
			manufacturer.setCity(city);

			manufacturerService.save(manufacturer);
		}

		request.setAttribute("manufacturers", manufacturerService.findAll());
		request.setAttribute("cities", cityRepo.getAll());
		return WebConstant.PAGE_HOME;
	}

}
