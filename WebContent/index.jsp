<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<body onload="gmapinit(); time();">

	<%@ page import="java.util.ArrayList"%>
	<%@ page import="se.webdev.ju15.model.DataBean"%>
	<%@ page import="se.webdev.ju15.Controller.Controller"%>

	<%
		ArrayList<DataBean> newList = (ArrayList<DataBean>) session.getAttribute("newList");
		ArrayList<DataBean> highList = (ArrayList<DataBean>) session.getAttribute("highList");
	%>


	<nav class="navbar navbar-default">
	<h1>Stockholm diaries:</h1>
	<div class=links>
	<div id="clock"></div>
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

	<div class="col-md-5 content">
	
	<ul>
			<p>Highest rated posts</p>
			<c:forEach var="current" begin="0" end="2" items="${sessionScope.highList}">
				<form action="/Projektuppgift_webdev/vote" method="POST" onClick="">
					<input value="${current.id }" type="hidden" name="vote">
					${current.votes }
					<button value="up" name="upordown" type="submit">+</button>
					<button value="down" name="upordown" type="submit">-</button>
					${current.name}: ${ current.message } <br>
				</form>
					<br>
			</c:forEach>
		</ul>


		<ul>
			<p>New posts</p>
			<c:forEach var="current" items="${sessionScope.newList}">
				<form action="/Projektuppgift_webdev/vote" method="POST">
					<input value="${current.id }" type="hidden" name="vote">
					${current.votes }
					<button value="up" name="upordown" type="submit">+</button>
					<button value="down" name="upordown" type="submit">-</button>
					${current.name}: ${ current.message } <br>
				</form>
				<br>
			</c:forEach>
		</ul>

	</div>

	<div class="col-md-4 content" >
			<p id="showText"></p>
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
	
	<script type="text/javascript" src="main.js"></script>
</body>
</html>