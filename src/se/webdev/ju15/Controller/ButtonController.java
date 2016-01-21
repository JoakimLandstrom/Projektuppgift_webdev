package se.webdev.ju15.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ButtonController
 */
@WebServlet("/ButtonController")
public class ButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		String name = req.getParameter("vote");
		HttpSession session = req.getSession();
		String
		
		
	
	}
}
