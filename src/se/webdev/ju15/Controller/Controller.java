package se.webdev.ju15.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SortingFocusTraversalPolicy;

import se.webdev.ju15.bean.DataBean;
import se.webdev.ju15.db.GetFromDB;
import se.webdev.ju15.db.SetToDB;
import se.webdev.ju15.sort.SortFunctions;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered get request");
		
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		String path = "/index.jsp";
		String name = req.getParameter("name");
		String com = req.getParameter("comment");
		SetToDB sdb = new SetToDB();
		GetFromDB gdb = new GetFromDB();
		DataBean nb = new DataBean("2", name, com, "Stockholm", "1");
		SortFunctions sort = new SortFunctions();
		
		
		
		try {
			sdb.writeBean(nb);
			list = gdb.getDataFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sort.random(list);
		try {
			sdb.updateDb(nb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			list = gdb.getDataFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.get(0).voteForBean();
		for (DataBean dataBean : list) {
			System.out.println(dataBean.getId() + " " + dataBean.getVotes());
		}
		
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
//		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}


}