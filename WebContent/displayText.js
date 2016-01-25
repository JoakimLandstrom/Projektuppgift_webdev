

function loadMessage() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			document.getElementById("showText").innerHTML = xhttp.responseText;
		}
	};

	xhttp.open("GET", "/Projektuppgift_webdev/GetMessage", true);
	xhttp.send();
	
}

function hideMessage(){
	document.getElementById("showText").innerHTML="";
}
