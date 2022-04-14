package it.engineering.webapp.action.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;

public class LogoutAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return WebConstant.PAGE_INDEX;
	}

}
