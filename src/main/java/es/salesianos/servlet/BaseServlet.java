package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Activity;

public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected Activity getActivityFromRequest(HttpServletRequest req) {
		Activity activity = new Activity();
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("gauging"));
		activity.setName(req.getParameter("name"));
		System.out.println(activity.getName());
		Optional<String> optional = Optional.ofNullable(req.getParameter("gauging"));
		activity.setAforo(Integer.parseInt(optional.orElse("0")));
		System.out.println(activity.getAforo());
		return activity;
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}