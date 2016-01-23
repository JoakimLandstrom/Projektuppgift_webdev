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

public class VoteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		String objectId = req.getParameter("vote");
		
		GetFromDB gdb = new GetFromDB();
		SetToDB sdb = new SetToDB();
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		
		try{
			list = gdb.getDataFromDb();
			for (DataBean dataBean : list) {
				if(objectId.equals(""+dataBean.getId())){
					dataBean.voteForBean();
					sdb.updateDb(dataBean);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		SortFunctions sort = new SortFunctions();
		sort.highestRating(list);

		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		session.setAttribute("vote", objectId);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}


}