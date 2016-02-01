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
/**
 * 
 * @author Joakim
 *
 */
public class VoteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		String objectId = req.getParameter("vote");
		String upordown = req.getParameter("upordown");
		GetFromDB gdb = new GetFromDB();
		SetToDB sdb = new SetToDB();
		ArrayList<DataBean> newlist = new ArrayList<DataBean>();
		ArrayList<DataBean> highList = new ArrayList<DataBean>();
		ArrayList<DataBean> entirelist = new ArrayList<DataBean>();
		SortFunctions sort = new SortFunctions();
		
		try{
			entirelist = gdb.getDataFromDb();
			for (DataBean dataBean : entirelist) {
				if(objectId.equals(""+dataBean.getId())){
					if(upordown.equals("up")){
						dataBean.voteForBean();	
						sdb.updateDb(dataBean);
					}else if(upordown.equals("down")){
						dataBean.hateBean();
						sdb.updateDb(dataBean);
					}else{
						sdb.deleteFromDb(dataBean);
					}
					
				}
			}
			newlist = gdb.getDataFromDb();
			sort.newPosts(newlist);
			highList = gdb.getDataFromDb();
			sort.highestRating(highList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("newList", newlist);
		session.setAttribute("highList", highList);
		session.setAttribute("vote", objectId);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}


}