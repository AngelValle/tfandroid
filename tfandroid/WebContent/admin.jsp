<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>
<%
RequestHelper reqHelper=(RequestHelper)session.getAttribute("requestHelper");
if(session.getAttribute("admin")!=null){
%>

</hr>
Crear Marca</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="1"/>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
</br></br></br></br></br></br>










Crear Modelo</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
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








Crear Noticia</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="3"/>
Titulo:<input type="text" name="titulo"/></br>
Descripcion:<textarea name="descripcion"></textarea></br>
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











Crear descarga</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="4"/>
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
Descripcion:<textarea name="descripcion"></textarea></br>
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
<%	
}
%>
</br></br></br></br>
<iframe src="http://www.quackit.com/html/online-html-editor/full/" width="100%" height="1000px"></iframe></br>
<iframe src="http://www.garyshood.com/htmltobb/" width="100%" height="1000px"></iframe>
