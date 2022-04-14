package it.engineering.webapp.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.repository.ManufacturerRepository;

public class HomeGetAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", new ManufacturerRepository().getAll());
		return WebConstant.PAGE_HOME;
	}

}
