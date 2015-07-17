<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<b><%=RB.getString("menu.searchresult") %>:
</br></br>
<b><%=RB.getString("menu.downloads") %></b></br></br></br>
<%for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download download=(Download)reqHelper.getListaDescargas().get(x);	
%>
<center><div id="download"><%=download.getFecha()%></br><img width="90%" src="<%=download.getUrlimagen()%>"/></br><%=download.getTitulo()%></br><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>"><%=RB.getString("home.showdetails") %></a></div></center>
<% }%>

</br></br></br>
<b><%=RB.getString("menu.news") %></b></br></br></br>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<center><div id="noticia"><%=noticia.getFecha()%></br><img width="90%" src="<%=noticia.getUrl()%>"/></br><%=noticia.getTitulo()%></br><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=RB.getString("home.readmore") %></a></div></center>
<% }%>
</div>
</div>
</div>

<%@include file="footer.jsp" %>
