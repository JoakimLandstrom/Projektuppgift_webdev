function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      document.getElementById("showText").innerHTML = xhttp.responseText;
    }
  };
  xhttp.open("POST", "message", true);
  xhttp.send();
}