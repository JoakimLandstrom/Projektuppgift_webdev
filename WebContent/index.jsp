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
<%@ page import = "se.webdev.ju15.bean.DataBean" %>

<%
ArrayList<DataBean> sortedComments = (ArrayList<DataBean>) session.getAttribute("sortedComments");
ArrayList<DataBean> recentComments = (ArrayList<DataBean>) session.getAttribute("unsortedComments");
%>



	<nav class="navbar navbar-default">
	<h1>Travel Diary</h1>
	<div class=links>
		<ul class="nav navbar-nav navbar-center">
			<a href="#"><div>Post</div></a>
		</ul>
		<a href="#"><div>Highest rating</div></a>
		</ul>
		<a href="#"><div>New</div></a>
		</ul>
		<a href="#"><div>FAQ</div></a>
		</ul>
	</div>
	</nav>

	<div class="col-md-7 content" id="test"></div>
	<div class="col-md-3 apicontent" id="map"></div>
	
	<div id="comments">
		<form action="#" method="post" name="submission">
			<p>Name: </p><input type="text" name="name" maxlength="50">
			<p>Comment: </p><input type="text" name="comment" maxlength="2000">
			<input type="submit" name="submission">
		</form>
	</div>
	
	<div id="commentList">
		<form action="/Projektuppgift_webdev/Submit" name="vote">
			<ul>
			<li><p>Highest rated comments</p></li>
				<li><p><%= sortedComments.get(0).getName() %></p><input type="submit" value="0"></li>
				</ul>
		</form>
	</div>



<script type = "text/javascript" src = "main.js"></script>
</body>
</html>