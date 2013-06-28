/*简单封装*/
function showWindow(url,name,width,height) {   
	var popup_width = 400;   
	var popup_height = 350;   
	var popup_left = (screen.width - popup_width) / 2;   
	var popup_top = (screen.height - popup_height) / 2;   
	var popup_scrollbars = "no";    
	var popup_property = "width=" + popup_width;   
	var popup_property = popup_property + ",height=" + popup_height;  
	var popup_property = popup_property + ",left=" + popup_left;  
    var popup_property = popup_property + ",top=" + popup_top;   
	var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;    	
	
	window.open(url,name,popup_property); 
	
} 
function showDialog(url,name,width,height){
	
	var popup_width = width==undefined|width==''?400:width;   
	var popup_height = height==undefined|height==''?350:height;   
	
	//居中显示
	var popup_left = (screen.width - popup_width) / 2;   
	var popup_top = (screen.height - popup_height) / 2;   
	
	var popup_show = "no";    
	var popup_property = "dialogwidth=" + popup_width+"px";   
	popup_property = popup_property + ",dialogheight=" + popup_height+"px";  
	popup_property = popup_property + ",dialogLeft=" + popup_left;  
    popup_property = popup_property + ",dialogTop=" + popup_top;   
	popup_property = popup_property + ",status=" + popup_show; 
	
	
	return window.showModalDialog(url,name,popup_property);
	
}