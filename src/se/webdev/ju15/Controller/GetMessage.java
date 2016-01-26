package se.webdev.ju15.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.webdev.ju15.bean.DataBean;

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
		String text="";
		
		String urlBit="";
		urlBit=req.getRequestURI().substring(req.getRequestURI().length()-2, req.getRequestURI().length());

		
		switch(urlBit){
			case "h0":text=highList.get(0).getMessage();break;
			case "h1":text=highList.get(1).getMessage();break;
			case "h2":text=highList.get(2).getMessage();break;
			case "n0":text=newList.get(0).getMessage();break;
			case "n1":text=newList.get(1).getMessage();break;
			case "n2":text=newList.get(2).getMessage();break;
			case "n3":text=newList.get(3).getMessage();break;
			case "n4":text=newList.get(4).getMessage();break;
			case "n5":text=newList.get(5).getMessage();break;
			case "n6":text=newList.get(6).getMessage();break;
			case "n7":text=newList.get(7).getMessage();break;
		}
		
		
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(text);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}