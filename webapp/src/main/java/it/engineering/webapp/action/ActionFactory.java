package it.engineering.webapp.action;

import it.engineering.webapp.action.login.LoginGetAction;
import it.engineering.webapp.action.login.LoginPostAction;
import it.engineering.webapp.action.logout.LogoutAction;
import it.engineering.webapp.action.manufacturer.ManufacturerDeleteAction;
import it.engineering.webapp.action.manufacturer.ManufacturerDeleteConfirmAction;
import it.engineering.webapp.constant.WebConstant;

public class ActionFactory {
	
	public static AbstractAction createAction(String method,String path) {
		AbstractAction action = null;
		
		switch(path) {
			case WebConstant.PATH_LOGIN: 
				if(method.equalsIgnoreCase("GET"))
					action = new LoginGetAction();	

				if(method.equalsIgnoreCase("POST"))
					action = new LoginPostAction(); 
				
				break;
				
			case WebConstant.PATH_MANUFACTURER_DELETE:
				action = new ManufacturerDeleteAction();
				break;
			case WebConstant.PATH_MANUFACTURER_DELETE_CONFIRM:
				action = new ManufacturerDeleteConfirmAction();
				break;
				
			case WebConstant.PATH_LOGOUT:
				action = new LogoutAction();
				break;
				
			
		}
		
		return action;
	}
}
