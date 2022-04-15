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

public class ManufacturerAddAction extends AbstractAction{

	private CityServiceImpl cityService;
	
	public ManufacturerAddAction() {
		cityService =new CityServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setAddress(request.getParameter("address"));
		manufacturer.setCid(request.getParameter("cid"));
		manufacturer.setPib(request.getParameter("pib"));
		
		City city = cityService.find(Long.parseLong(request.getParameter("city"))).orElse(null);
		manufacturer.setCity(city);
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_ADD;
	}

}
