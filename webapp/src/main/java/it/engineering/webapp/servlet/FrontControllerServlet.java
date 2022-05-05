package it.engineering.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.webapp.controller.ApplicationController;

//@WebServlet(urlPatterns = "/application/*")
public class FrontControllerServlet extends HttpServlet{
	
	private ApplicationController applicationController;
	
	@Override
	public void init() throws ServletException {
		super.init();
		applicationController = new ApplicationController();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = applicationController.processRequest(req, resp);
		req.getRequestDispatcher(page).forward(req, resp);
	}
}
