<%@page import="com.nic.businesscomponent.CuocoBC"%>
<%
	String user = request.getParameter("username");
	if (user == null && request.getMethod().equals("GET")) {
%>
<%@include file="accessonegato.jsp"%>
<%
	} else {
%>
<jsp:useBean id="utente" class="com.nic.businesscomponent.beans.Cuoco"
	scope="page" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="cdn.html"%>
<link rel="stylesheet" href="css/style.css">
<title>Registrazione</title>
</head>
<body>
	<%
			utente.setNome(request.getParameter("nome"));
			utente.setUsername(user);
			utente.setPassword(request.getParameter("password"));
			CuocoBC.getFactory().create(utente);
			
			session.setAttribute("username", user);
	%>
	<div class="container">
		<div class="page-header">
			<h3>Registrazione effettuata</h3>
		</div>
		<p>
			<a href="home.jsp">Back Home</a>
		</p>
		<div id="push"></div>
	</div>
	<%@include file="footer.html"%>
</body>
</html>
<%
	}
%>
