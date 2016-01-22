<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<script src="http://use.edgefonts.net/poiret-one.js"></script>
<link rel="stylesheet" type="text/css" href="mystyle.css" />
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stockholm</title>

</head>
<body onload="gmapinit()">

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "se.webdev.ju15.model.DataBean" %>
<%@ page import = "se.webdev.ju15.Controller.Controller" %>

<%
ArrayList<DataBean> sorted = (ArrayList<DataBean>) session.getAttribute("list");
ArrayList<DataBean> highest = (ArrayList<DataBean>) session.getAttribute("highList");
int size = highest.size()-1;
System.out.println(sorted.get(0).getName());
%>



<nav class="navbar navbar-default">
	<h1>Travel Diary</h1>
	<div class=links>
		<ul class="nav navbar-nav navbar-center">
			<a href="#"><div>Post</div></a>
		</ul>
		<a href="#"><div>Hot</div></a>
		</ul>
		<a href="#"><div>Newest</div></a>
		</ul>
		<a href="#"><div>FAQ</div></a>
		</ul>
	</div>
	</nav>
	
	<div class="col-md-7 content" id="test">

	<ul>
		<li><p>Highest ratings</p></li>
		<li><p><%=sorted.get(0).getName()+": "+sorted.get(0).getMessage() %></p></li>
		<li><p><%= sorted.get(1).getName()+": "+sorted.get(1).getMessage() %></p></li>
		<li><p><%= sorted.get(2).getName()+": "+sorted.get(2).getMessage() %></p></li>
		<li><p>Other reviews</p></li>
		<li><p><%=highest.get(0).getName()+": "+highest.get(0).getMessage() %></p>
		<li><p><%=highest.get(1).getName()+": "+highest.get(1).getMessage() %></p>
		<li><p><%=highest.get(2).getName()+": "+highest.get(2).getMessage() %></p>
		<li><p><%=highest.get(3).getName()+": "+highest.get(3).getMessage() %></p>
		<li><p><%=highest.get(4).getName()+": "+highest.get(4).getMessage() %></p>
		<li><p><%=highest.get(5).getName()+": "+highest.get(5).getMessage() %></p>
		<li><p><%=highest.get(size-1).getName()+": "+highest.get(size-1).getMessage() %></p>
		<li><p><%=highest.get(size).getName()+": "+highest.get(size).getMessage() %></p>
		
	</ul>

</div>
	
	
	
	</div>
	<div class="col-md-3 apicontent" id="map"></div>
	
	<div id="comments">
		<form action="/Projektuppgift_webdev/submit" method="POST" name="submission">
			<p>Name: </p><input type="text" name="name" maxlength="50">
			<p>Comment: </p><input type="text" name="comment" maxlength="2000">
			<input type="submit" name="submission">
		</form>
	</div>

<script type = "text/javascript" src = "main.js"></script>
</body>
</html>