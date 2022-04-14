package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.City;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;

public class ManufacturerAddConfirmAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		CityRepository cityRepo = new CityRepository();
		Manufacturer manufacturer = new Manufacturer();
		ManufacturerRepository manuRepo = new ManufacturerRepository();
		if(request.getParameter("option").equalsIgnoreCase("confirm")) {
			manufacturer.setAddress(request.getParameter("address"));
			manufacturer.setCid(request.getParameter("cid"));
			manufacturer.setPib(request.getParameter("pib"));
			City city = cityRepo.getById(Long.parseLong(request.getParameter("city"))).orElse(null);
			manufacturer.setCity(city);
			
			manuRepo.save(manufacturer);
		}
		
		request.setAttribute("manufacturers", manuRepo.getAll());
		request.setAttribute("cities", cityRepo.getAll());
		return WebConstant.PAGE_HOME;
	}

}
