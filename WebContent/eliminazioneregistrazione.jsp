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
<title>Conferma eliminazione</title>
<%@include file="cdn.html" %>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Ordine eliminato</h3>
	</div>
	<%
		session.removeAttribute("report");
	%>
	<a href="corsi.jsp">I miei corsi</a>
	<div id="push"></div>
</div>
<%@include file="footer.html" %>
</body>
</html>
<%
	}
%>
