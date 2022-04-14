package it.engineering.webapp.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;

public class LoginGetAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		return WebConstant.PAGE_LOGIN;
	}

}
