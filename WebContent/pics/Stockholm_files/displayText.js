/**
 * @author Daniel
 * @param x
 */
function loadMessage(x) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			document.getElementById("showText").innerHTML = xhttp.responseText;
		}
	};

	var url ="/Projektuppgift_webdev/message/"+x;
	xhttp.open("GET", url, true);
	xhttp.send();
}

function hideMessage(){
	document.getElementById("showText").innerHTML="";
}
/**
 * @author Joakim
 * @param y
 */
function loadLinkMessage(y){
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status == 200){
			document.getElementById("showText").innerHTML = xhttp.responseText;
			
		}
	};
	var url = "/Projektuppgift_webdev/link/"+y;
	xhttp.open("GET",url,true);
	xhttp.send();
}