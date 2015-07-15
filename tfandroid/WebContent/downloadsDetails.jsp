<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn2cols">
<div class="innertube">
<center>
<div id="noticiaDetails">
<%Download download=(Download)reqHelper.getDescargaActual();%>
<%=download.getDescipcion() %>
</div>
</center>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
