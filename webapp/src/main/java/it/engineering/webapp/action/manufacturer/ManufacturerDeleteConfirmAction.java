package it.engineering.webapp.action.manufacturer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.repository.ManufacturerRepository;

public class ManufacturerDeleteConfirmAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO DELETE manufacturer
		ManufacturerRepository manuRepo = new ManufacturerRepository();
		manuRepo.delete(Long.parseLong(request.getParameter("id")));
		request.setAttribute("manufacturers", new ManufacturerRepository().getAll());
		return WebConstant.PAGE_HOME;
	
	}

}
