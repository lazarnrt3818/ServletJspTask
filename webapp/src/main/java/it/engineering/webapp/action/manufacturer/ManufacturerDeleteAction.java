package it.engineering.webapp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class ManufacturerDeleteAction extends AbstractAction {

	private ManufacturerServiceImpl manufacturerService;

	public ManufacturerDeleteAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		Manufacturer manufacturer = manufacturerService.find(id).orElse(null);
		request.setAttribute("manufacturer", manufacturer);
		return WebConstant.PAGE_MANUFACTURER_DELETE;
	}

}
