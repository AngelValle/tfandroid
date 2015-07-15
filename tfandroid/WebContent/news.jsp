<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn2cols">
<div class="innertube">
<b>NOTICIAS:</b></br></br></br>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<center><div id="noticia"><%=noticia.getFecha()%></br><img height="90%" src="<%=noticia.getUrl()%>"/></br><%=noticia.getTitulo()%></br><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=RB.getString("home.readmore") %></a></div></center>
<% }%>
</div>
</div>
</div>

<%@include file="footer.jsp" %>
