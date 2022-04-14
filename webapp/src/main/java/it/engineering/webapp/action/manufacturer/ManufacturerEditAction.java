package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.City;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;

public class ManufacturerEditAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CityRepository cityRepo = new  CityRepository();
		ManufacturerRepository manuRepo = new ManufacturerRepository();
		Long id = Long.parseLong(request.getParameter("id"));
		Manufacturer manufacturer = manuRepo.getById(id).orElse(null);
		
		for(City c : cityRepo.getAll()) {
			System.out.println(c.getName());
		}
		request.setAttribute("cities", cityRepo.getAll());
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_EDIT;

	}

}
