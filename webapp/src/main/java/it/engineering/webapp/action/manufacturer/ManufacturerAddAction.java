package it.engineering.webapp.action.manufacturer;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.constraint.MyConstraint;
import it.engineering.webapp.domain.CityEntity;
import it.engineering.webapp.domain.ManufacturerEntity;
import it.engineering.webapp.service.impl.CityServiceImpl;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;
import it.engineering.webapp.validator.ManufacturerValidator;

public class ManufacturerAddAction extends AbstractAction{

	private CityServiceImpl cityService;
	private ManufacturerServiceImpl manufacturerService;
	private ManufacturerValidator manufacturerValidator;
	
	public ManufacturerAddAction() {
		cityService =new CityServiceImpl();
		manufacturerService = new ManufacturerServiceImpl();
		manufacturerValidator = new ManufacturerValidator();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ManufacturerEntity manufacturer = new ManufacturerEntity();
		String pib = request.getParameter("pib");
		String cid = request.getParameter("cid");
		String address = request.getParameter("address");
		CityEntity city = cityService.find(Long.parseLong(request.getParameter("city"))).orElse(null);
		
		manufacturer.setCity(city);
		manufacturer.setAddress(address);
		manufacturer.setCid(cid);
		manufacturer.setPib(pib);
		
		List<MyConstraint> errors = manufacturerValidator.validate(manufacturer);
		
		if(!errors.isEmpty()) {
			
			for(MyConstraint error : errors) {
				if(error.equals(MyConstraint.MANUFACTURER_CID_NUMBER))
					request.setAttribute("error_cid", "input-error");
				if(error.equals(MyConstraint.MANUFACTURER_PIB_NUMBER))
					request.setAttribute("error_pib", "input-error");
				if(error.equals(MyConstraint.MANUFACTURER_EMPTY_FIELD))
					request.setAttribute("error_address", "input-error");
			}
			
			
			request.setAttribute("manufacturers", manufacturerService.findAll());
			request.setAttribute("cities", cityService.findAll());
			request.setAttribute("errors",errors.stream().map(e -> e.getDesc()).collect(Collectors.toList()));
			request.setAttribute("manufacturer", manufacturer);
			return WebConstant.PAGE_HOME;
		}
		
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_ADD;
	}

}
