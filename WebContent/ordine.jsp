<%
	String user = (String)session.getAttribute("username");
	if(user == null){
%>
<%@include file="accessonegato.jsp" %>
<%
	} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="carrello" class="com.nic.businesscomponent.beans.Carrello" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma ordine</title>
<%@include file="cdn.html" %>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Ordine confermato</h3>
	</div>
	<p>Codice del tuo ordine:&nbsp;
	<%= session.getAttribute("idordine") %></p>
	<hr>
	<%
		session.removeAttribute("carrello");
	%>
	<a href="sceltacorso.jsp">Compra ancora</a>
	<div id="push"></div>
</div>
<%@include file="footer.html" %>
</body>
</html>
<%
	}
%>
