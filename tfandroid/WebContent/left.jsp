<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>
<div id="leftcolumn">
<div class="innertube">
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<div id="noticiaLeft"><%=noticia.getFecha()%></br><img width="90%" src="<%=noticia.getUrl()%>"/></br><%=noticia.getTitulo()%></br><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=RB.getString("home.readmore") %></a></div>
<% }%>
</div>
</div>