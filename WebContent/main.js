
/*
 * @Author Joakim
 */


function gmapinit() {
		
		var latlng = {lat: 59.32932, lng: 18.06858};
		
		var map = new google.maps.Map(document.getElementById("map"), {
			center : latlng,
			zoom : 9,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});
		
		var marker = new google.maps.Marker({
		    position: position,
		    map: map,
		    title: ''
		  });
				
	}

	google.maps.event.addDomListener(window, 'load', gmapinit);

