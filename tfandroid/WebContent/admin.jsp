<%
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
Crear Modelo</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
<input type="text" name="marca"/></br>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
Crear descarga</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="3"/>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
<%	
}
%>