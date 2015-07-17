<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>
<%@include file="headeradmin.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<%
if(session.getAttribute("admin")!=null){
%>
<%if(reqHelper.getAction()==0){ %>
</hr>
Crear Marca</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="1"/>
<input type="hidden" name="subaction" value="1"/>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
</br></br></br></br></br></br>
<%}%>








<%if(reqHelper.getAction()==1){ %>
Crear Modelo</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
<input type="hidden" name="subaction" value="1"/>
Marca:<select name="marca">
<%
if(reqHelper.getListaMarcas()!=null){
for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
%>
<option value="<%=marca.getIdmarca()%>"><%=marca.getTitulo() %></option>
<%}
}%>
</select></br>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
</br></br></br></br></br>
<%}%>






<%if(reqHelper.getAction()==2){ %>
Crear Noticia</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="3"/>
<input type="hidden" name="subaction" value="1"/>
Titulo:<input type="text" name="titulo"/></br>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea></br>
Url Imagen:<input type="text" name="urlimagen"/></br>
Idioma:<select name="idioma">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select></br>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select></br></br>
<input type="submit"/></br>
</form>
</br></br></br></br></br></br>
<iframe src="http://www.quackit.com/html/online-html-editor/full/" width="100%" height="1000px"></iframe></br>
<iframe src="http://www.garyshood.com/htmltobb/" width="100%" height="1000px"></iframe>
<%}%>


<%if(reqHelper.getAction()==3){ %>
Crear Banner</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="3"/>
<input type="hidden" name="subaction" value="1"/>
Titulo:<input type="text" name="titulo"/></br>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea></br>
Url Imagen:<input type="text" name="urlimagen"/></br>
Idioma:<select name="idioma">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select></br>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select></br></br>
<input type="submit"/></br>
</form>
</br></br></br></br></br></br>
<%}%>








<%if(reqHelper.getAction()==4){ %>
Crear descarga</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="4"/>
<input type="hidden" name="subaction" value="1"/>
Marca:<select name="marca">
<%
if(reqHelper.getListaMarcas()!=null){
for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
%>
<option value="<%=marca.getIdmarca()%>"><%=marca.getTitulo() %></option>
<%}
}%>
</select></br>
Modelo:<select name="modelo">
<%
if(reqHelper.getListaModelos()!=null){
for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
%>
<option value="<%=modelo.getIdmodelo()%>"><%=modelo.getTitulo() %></option>
<%}
}%>
</select></br>
Titulo:<input type="text" name="titulo"/></br>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea></br>
Url Imagen:<input type="text" name="urlimagen"/></br>
Idioma:<select name="idioma">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select></br>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select></br></br>
<input type="submit"/></br>
</form>
</br></br></br></br></br></br>
<iframe src="http://www.quackit.com/html/online-html-editor/full/" width="100%" height="1000px"></iframe></br>
<iframe src="http://www.garyshood.com/htmltobb/" width="100%" height="1000px"></iframe>
<%	
}
%>

<%} %>
</div>
</div>
</div>
<%@include file="footer.jsp" %>