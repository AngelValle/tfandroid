<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>

<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<script src="js/scripts.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TF Android Developers</title>
</head>
<body>
<%RequestHelper reqHelper=(RequestHelper)session.getAttribute("requestHelper");
ResourceBundle RB = ResourceBundle.getBundle("texts", new Locale(reqHelper.getLang()));
%>
<div id="maincontainer">

<div id="topsection"><div id="logo"><div class="innertube">
	<a href=""><img src="images/logoblanco.png"/></a>
	<div id="banner">
		<a href="" target="_blank"><img src="images/banners/d83a_jiayu-aplica9.gif" width="400px" height="90px"/>
	</div>
	<div id="languagesearchsocial">
		<form method="post" action="AdminServlet">
		<a href="AdminServlet?language=es" ><img src="images/EspanaBanderaIcono.png" width="40px"/></a><a href="AdminServlet?language=en"><img src="images/ReinoUnidoBanderaIcono.png" width="40px"/></a>          
		<input type="hidden" name="action" value="20"/>
			<%=RB.getString("home.search") %> <input type="text" name="textSearch" size="30"/>  
			<a href="http://www.facebook.com/" target="_blank"><img src="images/facebook.jpg" width="40px"/></a><a href="" target="_blank"><img src="images/twiter.jpg" width="40px"/></a><a href="" target="_blank"><img src="images/googleplus.jpg" width="40px"/></a>
		</form> 
	</div>

<br/><br/>

</div>
</div>
</div>
<div id='cssmenu'>
<ul>
   <li class='<%=reqHelper.getAction()==0 ? "active " : ""%> '><a href='AdminServlet?action=0'><span>Marcas</span></a></li>
   <li class='<%=reqHelper.getAction()==1 ? "active " : ""%>'><a href='AdminServlet?action=1'><span>Modelos</span></a></li>
   <li class='<%=reqHelper.getAction()==2 ? "active " : ""%>'><a href='AdminServlet?action=2'><span>Noticias</span></a></li>
   <li class='<%=reqHelper.getAction()==3 ? "active " : ""%>'><a href='AdminServlet?action=3'><span>Banners</span></a></li>
   <li class='<%=reqHelper.getAction()==4 ? "active " : ""%>'><a href='AdminServlet?action=4'><span>Descargas</span></a></li>
   <li class='<%=reqHelper.getAction()==5 ? "active " : ""%>'><a href='AdminServlet?action=5'><span>Foro</span></a></li>
</ul>
</div>