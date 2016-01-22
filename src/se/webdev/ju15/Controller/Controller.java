package se.webdev.ju15.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		ArrayList<DataBean> highList = new ArrayList<DataBean>();
		String x = req.getParameter("show");
		String name = req.getParameter("name");
		String com = req.getParameter("comment");
		SetToDB sdb = new SetToDB();
		GetFromDB gdb = new GetFromDB();
		DataBean nb = new DataBean("1", name, com, "1");
		SortFunctions sort = new SortFunctions();
		
		try{
			if(x.equals("show")){
				try {
					list = gdb.getDataFromDb();
					sort.random(list);
					highList = sort.highestRating(list);
					System.out.println(list.get(0).getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}				
		}
		}catch(Exception e){
			try {
				sdb.writeBean(nb);
				list = gdb.getDataFromDb();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sort.random(list);
			highList = sort.highestRating(list);
			for (DataBean dataBean : list) {
				System.out.println(dataBean.getName());
			}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}


}