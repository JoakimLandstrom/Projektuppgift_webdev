/*
 * @Author Joakim
 */

var location = function (location){
	
	var array = [location];
	
	return array;	
}

function gmapinit() {

	var latlng = {
		lat : 59.32932,
		lng : 18.06858
	};

	var map = new google.maps.Map(document.getElementById("map"), {
		center : latlng,
		zoom : 9,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
	google.maps.event.addDomListener(window, 'load', gmapinit);

	var marker = new google.maps.Marker({
		position : location,
		map : map
	});
	marker.setMap(map);
}

function time() {
	var today = new Date();

	document.getElementById('clock').innerHTML = addTen(today.getHours()) + ":"
			+ addTen(today.getMinutes()) + ":" + addTen(today.getSeconds());
	var timeout = setTimeout(time, 500);
}
function addTen(time) {
	if (time < 10) {
		time = "0" + time;
	}
	return time;
}
