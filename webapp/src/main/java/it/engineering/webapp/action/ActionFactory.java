package it.engineering.webapp.action;

import it.engineering.webapp.action.login.LoginGetAction;
import it.engineering.webapp.action.login.LoginPostAction;
import it.engineering.webapp.action.logout.LogoutAction;
import it.engineering.webapp.action.manufacturer.ManufacturerAddAction;
import it.engineering.webapp.action.manufacturer.ManufacturerAddConfirmAction;
import it.engineering.webapp.action.manufacturer.ManufacturerDeleteAction;
import it.engineering.webapp.action.manufacturer.ManufacturerDeleteConfirmAction;
import it.engineering.webapp.action.manufacturer.ManufacturerEditAction;
import it.engineering.webapp.action.manufacturer.ManufacturerEditConfirmAction;
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
				
			case WebConstant.PATH_MANUFACTURER_EDIT:
				action = new ManufacturerEditAction();
				break;
				
			case WebConstant.PATH_MANUFACTURER_EDIT_CONFIRM:
				action = new ManufacturerEditConfirmAction();
				break;
				
			case WebConstant.PATH_MANUFACTURER_ADD:
				action = new ManufacturerAddAction();
				break;
				
			case WebConstant.PATH_MANUFACTURER_ADD_CONFIRM:
				action = new ManufacturerAddConfirmAction();
				break;	
			case WebConstant.PATH_LOGOUT:
				action = new LogoutAction();
				break;
				
			
		}
		
		return action;
	}
}
