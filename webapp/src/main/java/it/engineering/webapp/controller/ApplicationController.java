package it.engineering.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		AbstractAction action = ActionFactory.createAction(method,path);
		
		return action.execute(request, response);
	}
}
