package se.webdev.ju15.Controller;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.webdev.ju15.model.DataBean;

import java.io.*;

/**
 * Servlet implementation class GetMessage
 */
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<DataBean> highList;
		ArrayList<DataBean> randomList;
		ArrayList<DataBean> newList;
		
		HttpSession session =req.getSession();
		highList=(ArrayList<DataBean>) session.getAttribute("highList");
		randomList=(ArrayList<DataBean>) session.getAttribute("randomList");
		newList=(ArrayList<DataBean>) session.getAttribute("newList");
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(highList.get(0).getMessage());
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
