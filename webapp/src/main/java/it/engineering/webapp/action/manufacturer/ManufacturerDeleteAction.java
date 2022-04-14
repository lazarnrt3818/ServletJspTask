package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.ManufacturerRepository;

public class ManufacturerDeleteAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ManufacturerRepository manuRepo = new ManufacturerRepository();
		Long id = Long.parseLong(request.getParameter("id"));
		Manufacturer manufacturer = manuRepo.getById(id).orElse(null);
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_DELETE;
	}

}
