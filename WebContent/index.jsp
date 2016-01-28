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
<div class="col-md-12" style="padding:0px">
	<nav class="navbar navbar-default">
	<div class="col-md-4" style="padding:0px">
	<p class="h1">Stockholm diaries</p>
	</div>
	
	<div class="col-md-6 links">
		<ul class="nav navbar-nav navbar-center">
		<a href="/Projektuppgift_webdev/show"><p class="linktext">Stories</p></a>
		
		<a><p class="linktext" onclick ="loadLinkMessage('b')">Bars</p></a>
		
		<a><p class="linktext" onclick ="loadLinkMessage('c')">Clubs</p></a>
		
		<a><p class="linktext" onclick ="loadLinkMessage('r')">Restaurants</p></a>
		
		<a><p class="linktext" onclick ="loadLinkMessage('a')" >Attractions</p></a>
		
		</ul>
	</div>
	<div id="clock"></div>
	</nav>
</div>
	<div class="col-md-3 content">
	
	<ul>
			<p>Highest rated posts</p>
			<c:forEach var="current" begin="0" end="2" items="${sessionScope.highList}" varStatus="loop">
				<form action="/Projektuppgift_webdev/vote" method="POST" onclick="loadMessage('h'+'${loop.index}');">
					<div>
					<input value="${current.id }" type="hidden" name="vote">
					${current.votes }
					<input class="delete" value="delete" name="upordown" type="submit">
					<input class="up" value="up" name="upordown" type="submit">
					<input class="down" value="down" name="upordown" type="submit">
					${current.name}
					</div>
				</form>
					<br>
			</c:forEach>
		</ul>


		<ul>
			<p>New posts</p>
			<c:forEach var="current" items="${sessionScope.newList}" varStatus="loop" begin="0" end="7">
				<form action="/Projektuppgift_webdev/vote" method="POST" onclick="loadMessage('n'+'${loop.index}');">
					<input value="${current.id }" type="hidden" name="vote">
					<div>
					${current.votes }
					<input class="delete" value="delete" name="upordown" type="submit">
					<input class="up" value="up" name="upordown" type="submit">
					<input class="down" value="down" name="upordown" type="submit">
					${current.name}
					</div> 
				</form>
				<br>
			</c:forEach>
		</ul>

	</div>

	<div class="col-md-6 content" onclick="hideMessage()">
			<p id="showText"></p>
	</div>
	<div class="col-md-3 apicontent" id="map"></div>

	
	<div class="col-md-3 comments">
		<form action="/Projektuppgift_webdev/submit" method="POST" name="submission">
			Be a part of the backpacker conversation: 
			<div>Title:<br> <input type="text" name="name" id="title" maxlength="24"></div>
			<div>Comment: <textarea maxlength="1024" id="comment" name="comment" ></textarea></div>
	</div>
	<div class ="col-md-3"><input class="submit" type="submit" name="submission"></div>
	</form>
	<script type="text/javascript" src="displayText.js"></script>
	<script type="text/javascript" src="main.js"></script>
</body>
</html>