package it.engineering.webapp.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.webapp.action.AbstractAction;
import it.engineering.webapp.constant.WebConstant;
import it.engineering.webapp.domain.User;

public class LoginPostAction extends AbstractAction {

	@SuppressWarnings("unused")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User("user", "user", null, null);
		
		if (user != null) {
			HttpSession session = request.getSession(true);
			User loginUser = user.clone();
			session.setAttribute("loginUser",loginUser);
			return WebConstant.PAGE_HOME;
		} else {
			request.setAttribute("error_message", "Korisnik ne postoji !");
			return WebConstant.PAGE_LOGIN;
		}
	}

}
