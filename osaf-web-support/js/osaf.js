/*
 * OSAF 2.0
 * JavaScript Library
 */

function deleteConfirm(url) {
	var res = confirm("Are you sure?");
	if (res == true) 
		document.location.href = url; 
}

/**
 * Function: popup
 *
 **/
var openWindow = '';
var popup = function(url, name, w, h, scroll, resize){	
	if (openWindow && !openWindow.closed && openWindow.location){
		openWindow.location.href = url;		
	}
	else{
		var l, t;
		if(window.screen.width - w <= 11)
			l = 0;
		else
			l = (window.screen.width-w)/2;
			
		if(window.screen.height - h <= 90)
			t = 0;
		else
			t = (window.screen.height-h)/2;

		window.open(url,name,'status=no, width='+w+',height='+h+',left='+l+',top='+t+',screenX='+l+',screenY='+t+',scrollbars='+scroll+',resizable='+resize);		
	}
	if (openWindow && window.focus) { openWindow.focus(); }
	
	return false;
}

/**
 * Function: getGridSelectedId
 *
 **/
var getGridSelectedId = function(gridid) {
	if (!gridid) var gridid = "maingrid";	// default gridid
	
	if ($(gridid).contentWindow.getSelectedId)
		return $(gridid).contentWindow.getSelectedId();
	else
		return null; // grid not ready
}

var getGridSelectedIds = function(gridid) {
	if (!gridid) var gridid = "maingrid";	// default gridid
	
	if ($(gridid).contentWindow.getSelectedIds)
		return $(gridid).contentWindow.getSelectedIds();
	else
		return null; // grid not ready
} 

 var hasValue = function(value) {
 	return value != null && value != '';
 }
 
 var toggledisplay = function(id) {
 	if ($(id).style.display == 'block') { 
 		$(id).style.display = 'none';
 	}
 	else { 
 		$(id).style.display = 'block';
 	}
 }
 
 