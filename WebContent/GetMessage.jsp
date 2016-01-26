<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.io.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="se.webdev.ju15.bean.DataBean" %>
    
<% 
		ArrayList<DataBean> highList;
		ArrayList<DataBean> randomList;
		ArrayList<DataBean> newList;
		highList=(ArrayList<DataBean>) session.getAttribute("highList");
		randomList=(ArrayList<DataBean>) session.getAttribute("randomList");
		newList=(ArrayList<DataBean>) session.getAttribute("newList");
		out.println(highList.get(0).getMessage());
		
%>