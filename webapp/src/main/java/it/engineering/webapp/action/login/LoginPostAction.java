package it.engineering.webapp.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.User;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.repository.UserRepository;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;

public class LoginPostAction extends AbstractAction {
	
	private ManufacturerServiceImpl manufacturerService;
	
	

	public LoginPostAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//List<User> users =  (List<User>)request.getServletContext().getAttribute("login_users");
		//&& !users.contains(user)
		
		User user = login(request);
		
		if (user != null) {
			
			//users.add(user);
			HttpSession session = request.getSession(true);
			CityRepository cityRepo = new CityRepository();
			
			User loginUser = user.clone();
			session.setAttribute("loginUser",loginUser);
			session.setAttribute("manufacturers", manufacturerService.findAll());
			request.setAttribute("cities", cityRepo.getAll());
			return WebConstant.PAGE_HOME;
		} else {
			request.setAttribute("error_message", "Wrong credentials !");
			return WebConstant.PAGE_LOGIN;
		}
	}

	
	private User login(HttpServletRequest request) {
		

		UserRepository userRepo = new UserRepository();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password, null, null);
		
		List<User> users = 	userRepo.getAll();
		
		for(User current : users) {
			if (current.equals(user)) {
				return current;
			}
		}
		return null;
	}
}
