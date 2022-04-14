package it.engineering.webapp.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.User;
import it.engineering.webapp.repository.UserRepository;

public class LoginGetAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		UserRepository userRepo = new UserRepository();
//		userRepo.save(new User("test", "pass", "Laki", "spass"));
		
		System.out.println(userRepo.getAll());
		return WebConstant.PAGE_LOGIN;
	}

}
