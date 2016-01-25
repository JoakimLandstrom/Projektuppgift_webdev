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
<script type="text/javascript" src="displayText.js"></script>
<script type = "text/javascript" src = "main.js"></script>
<body onload="gmapinit()">

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "se.webdev.ju15.model.DataBean" %>
<%@ page import = "se.webdev.ju15.Controller.Controller" %>

<%
ArrayList<DataBean> highList = (ArrayList<DataBean>)(ArrayList<DataBean>) session.getAttribute("highList");
ArrayList<DataBean> randomList = (ArrayList<DataBean>) session.getAttribute("randomList");
ArrayList<DataBean> newList = (ArrayList<DataBean>) session.getAttribute("newList");
%>

<nav class="navbar navbar-default">
	<h1>Stockholm diaries: </h1>
		<div class=links>
			<ul class="nav navbar-nav navbar-center">
				<a href="#"><div>Stories</div></a>
			</ul>
			<a href="#"><div>Bars</div></a>
			</ul>
			<a href="#"><div>Clubs</div></a>
			</ul>
			<a href="#"><div>Restaurants</div></a>
			</ul>
			<a href="#"><div>Attractions</div></a>
			</ul>
			</ul>
			<a href="#"><div></div></a>
			</ul>
			</ul>
		</div>
	</div>
	</nav>
	
		<div class="col-md-2 content" id="firstDiv">
			<ul id="name">
				<li class="title">Highest ratings:</li>
				<li onclick="loadMessage();"><%= highList.get(0).getName() %></li><li>
				<li><%= highList.get(1).getName() %></li>
				<li><%= highList.get(2).getName() %></li>
				<li class="title"><p>Recently added</p></li>
				<li><%=newList.get(0).getName() %></li>
				<li><%=newList.get(1).getName() %></li>
				<li><%=newList.get(2).getName() %></li>
				<li><%=newList.get(3).getName() %></li>
				<li class="title"><p>Other comments:</p></li>
				<li><%=randomList.get(0).getName() %></li>
				<li><%=randomList.get(1).getName() %></li>
				<li><%=randomList.get(2).getName() %></li>
				<li><%=randomList.get(3).getName() %></li>
			</ul>
		</div>
		
		<div class="col-md-3 content" >
			<p id="showText" onclick="hideMessage();"></p>
		</div>

	<div class="col-md-3 apicontent" id="map"></div>
	
	<div class="col-md-3 comments">
		<form action="/Projektuppgift_webdev/submit" method="POST" name="submission">
			Be a part of the backpacker conversation: 
			<div>Name:<br> <input type="text" name="name" maxlength="50"></div>
			<div>Comment: <textarea rows="6" cols="100" name="comment"></textarea></div>
			<input type="submit" name="submission">
		</form>
	</div>
	

</body>
</html>