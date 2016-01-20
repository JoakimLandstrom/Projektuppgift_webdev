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
<script>
	function initialize() {
		var mapProp = {
			center : new google.maps.LatLng(59.32932, 18.06858),
			zoom : 9,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);
	}

	google.maps.event.addDomListener(window, 'load', initialize);


	
   
</script>
</head>
<body>


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
	


	<div class="col-md-7 content" id="test"></div>
	<div class="col-md-3 apicontent" id="googleMap"></div>
	
	<div id="comments">
		<form action="/Projektuppgift_webdev/Submit" method="post" name="submission">
			<p>Name: </p><input type="text" name="name" maxlength="50">
			<p>Comment: </p><input type="text" name="comment" maxlength="2000">
			<input type="submit" name="submission">
		</form>
	</div>


</body>
</html>