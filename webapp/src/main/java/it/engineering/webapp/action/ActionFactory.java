package it.engineering.webapp.action;

import it.engineering.webapp.action.login.LoginGetAction;
import it.engineering.webapp.action.login.LoginPostAction;
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
		}
		
		return action;
	}
}
