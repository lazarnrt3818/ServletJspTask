package it.engineering.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractAction {
	public abstract String execute(HttpServletRequest request,HttpServletResponse response);
}
