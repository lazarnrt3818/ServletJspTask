package it.engineering.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.action.ActionFactory;

public class ApplicationController {
	
	
	/*	 
	*	Determine the action to be 
	*	returned based on the request
	*/
	public String processRequest(HttpServletRequest request,HttpServletResponse response) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println(path);
		AbstractAction action = requestAuthorization(request);
		
		return action.execute(request, response);
	}
	
	private AbstractAction requestAuthorization(HttpServletRequest request) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		HttpSession session = request.getSession();
		AbstractAction action = ActionFactory.createAction(method,path);
		
		if(session.getAttribute("loginUser") == null && !(method.equalsIgnoreCase("POST") && path.equalsIgnoreCase("/login"))) {
				action = ActionFactory.createAction("get", "/login");
		}
		return action;
	}
}
