package it.engineering.webapp.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.dto.UserDto;
import it.engineering.webapp.service.impl.CityServiceImpl;
import it.engineering.webapp.service.impl.ManufacturerServiceImpl;
import it.engineering.webapp.service.impl.UserServiceImpl;

public class LoginPostAction extends AbstractAction {
	
	private ManufacturerServiceImpl manufacturerService;
	private CityServiceImpl cityService;
	private UserServiceImpl userService;

	public LoginPostAction() {
		this.manufacturerService = new ManufacturerServiceImpl();
		this.cityService = new CityServiceImpl();
		this.userService = new UserServiceImpl();
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//List<User> users =  (List<User>)request.getServletContext().getAttribute("login_users");
		//&& !users.contains(user)
		
		UserDto user = userService.login(request.getParameter("username"), request.getParameter("password"));
		
		if (user != null) {
			
			//users.add(user);
			HttpSession session = request.getSession(true);
			
			session.setAttribute("loginUser",user);
			session.setAttribute("manufacturers", manufacturerService.findAll());
			request.setAttribute("cities", cityService.findAll());
			return WebConstant.PAGE_HOME;
		} else {
			request.setAttribute("error_message", "Wrong credentials !");
			return WebConstant.PAGE_LOGIN;
		}
	}

//	
//	private User login(HttpServletRequest request) {
//		
//
//		UserRepository userRepo = new UserRepository();
//		
//		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		User user = new User(username, password, null, null);
//		
//		List<User> users = 	userRepo.getAll();
//		
//		for(User current : users) {
//			if (current.equals(user)) {
//				return current;
//			}
//		}
//		return null;
//	}
}
