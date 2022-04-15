package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.City;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;

public class ManufacturerEditConfirmAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ManufacturerRepository manuRepo = new ManufacturerRepository();
		CityRepository cityRepo = new CityRepository();
		if(request.getParameter("option").equalsIgnoreCase("Edit")) {
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setAddress(request.getParameter("address"));
			manufacturer.setCid(request.getParameter("cid"));
			manufacturer.setPib(request.getParameter("pib"));
			manufacturer.setId(Long.parseLong(request.getParameter("id")));
			City city = cityRepo.getById(Long.parseLong(request.getParameter("city"))).orElse(null);
			manufacturer.setCity(city);
			manuRepo.update(manufacturer);
		}
		request.setAttribute("cities", cityRepo.getAll());
		request.setAttribute("manufacturers", manuRepo.getAll());
		return WebConstant.PAGE_HOME;
	}

}
