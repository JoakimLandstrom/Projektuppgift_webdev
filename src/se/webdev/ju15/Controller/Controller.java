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

import se.webdev.ju15.bean.DataBean;
import se.webdev.ju15.db.GetFromDB;
import se.webdev.ju15.db.SetToDB;
import se.webdev.ju15.sort.SortFunctions;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered get request");
		String path = "/index.jsp";
		ArrayList<DataBean> newlist = new ArrayList<DataBean>();
		ArrayList<DataBean> highList = new ArrayList<DataBean>();
		String name = req.getParameter("name");
		String com = req.getParameter("comment");
		SetToDB sdb = new SetToDB();
		GetFromDB gdb = new GetFromDB();
		DataBean nb = new DataBean("0", name, com, "Stockholm", "0");
		SortFunctions sort = new SortFunctions();
			
		try {
			sdb.writeBean(nb);
			highList = gdb.getDataFromDb();
			sort.highestRating(highList);
			newlist = gdb.getDataFromDb();
			sort.newPosts(newlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HttpSession session = req.getSession();
		session.setAttribute("newList", newlist);
		session.setAttribute("highList", highList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}


}