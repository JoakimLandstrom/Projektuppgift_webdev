package se.webdev.ju15.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.SortingFocusTraversalPolicy;

import se.webdev.ju15.model.DataBean;
import se.webdev.ju15.db.GetFromDB;
import se.webdev.ju15.db.SetToDB;
import se.webdev.ju15.sort.SortFunctions;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered get request");
		String path = "/index.jsp";
		ArrayList<DataBean> entireList = new ArrayList<DataBean>();
		ArrayList<DataBean> highList = new ArrayList<DataBean>();
		ArrayList<DataBean> randomList = new ArrayList<DataBean>();
		ArrayList<DataBean> newList = new ArrayList<DataBean>();
		
		String name = req.getParameter("name");
		String com = req.getParameter("comment");
		SetToDB sdb = new SetToDB();
		GetFromDB gdb = new GetFromDB();
		DataBean nb = new DataBean(name, com, "Stockholm", 1);
		SortFunctions sort = new SortFunctions();
			
		try {
			sdb.writeBean(nb);
			entireList = gdb.getDataFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		highList = sort.newPosts(entireList);
		randomList = sort.random(entireList);
		newList = sort.newPosts(entireList);

		HttpSession session = req.getSession();
		session.setAttribute("randomList", randomList);
		session.setAttribute("highList", highList);
		session.setAttribute("newList", newList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}
}