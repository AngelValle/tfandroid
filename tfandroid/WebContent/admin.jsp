<%
if(session.getAttribute("admin")!=null){
%>
Crear descarga</br>
<form>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
Crear Marca</br>
<form>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
Crear Modelo</br>
<form>	
<input type="text" name="marca"/></br>
Nombre:<input type="text" name="nombre"/></br>
<input type="submit"/></br>
</form>
</hr>
<%	
}
%>