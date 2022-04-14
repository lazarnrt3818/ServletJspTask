package it.engineering.webapp.listener;

import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import it.engineering.webapp.domain.User;

public class MyContextListener implements ServletContextListener  {
	@Override
	public void contextInitialized(ServletContextEvent sce)  { 
		
		sce.getServletContext().setAttribute("login_users", new ArrayList<User>());
    	
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
}
