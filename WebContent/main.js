
/*
 * @Author Joakim
 */
function gmapinit() {
		var mapProp = {
			center : new google.maps.LatLng(59.32932, 18.06858),
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map"),
				mapProp);
	}

	google.maps.event.addDomListener(window, 'load', gmapinit);

xmlhttp = new XMLHttpRequest();

xmlhttp.onreadystatechange = 
	function(){
	if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		document.getElementById("")
	}
}

xmlhttp.open("GET", "index.jsp", true);
xmlhttp.send();