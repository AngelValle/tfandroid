<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn2cols">
<div class="innertube">
<b><%=RB.getString("menu.downloads") %>::</b></br></br></br>
<%for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download download=(Download)reqHelper.getListaDescargas().get(x);	
%>
<center><div id="download"><%=download.getFecha()%></br><img height="90%" src="<%=download.getUrlimagen()%>"/></br><%=download.getTitulo()%></br><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>"><%=RB.getString("home.readmore") %></a></div></center>
<% }%>
</div>
</div>
</div>

<%@include file="footer.jsp" %>
