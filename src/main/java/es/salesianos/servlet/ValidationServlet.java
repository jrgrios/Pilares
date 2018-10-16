package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/Validation")
public class ValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	ActividadesRepository repository = new ActividadesRepository();
	
    public ValidationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		Activity activity = getActivityFromRequest(request);
		if(repository.activityIsRealizable(activity)) {
			redirect(request, response, "/ok.jsp");
		}
		redirect(request, response, "/fail.jsp");
	}

}
