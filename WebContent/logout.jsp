<%
	String user = (String)session.getAttribute("username");
	String admin = (String)session.getAttribute("admin");
	if(user == null && admin == null){
%>
<%@include file="accessonegato.jsp" %>
<%
	} else {
		session.invalidate();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<%@include file="cdn.html" %>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Logout della sessione</h3>
	</div>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Hai appena effettuato il logout</h3>
		</div>
		<div class="panel-body">
			<p>Per accedere di nuovo alla pagina, effettuare il login:
			<a href="login.jsp">Login</a></p>
		</div>
	</div>
	<div id="push"></div>
</div>
<%@include file="footer.html" %>
</body>
</html>
<%
	}
%>

