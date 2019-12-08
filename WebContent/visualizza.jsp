<%@page import="java.util.Enumeration"%>
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
<title>Riepilogo carrello</title>
<%@include file="cdn.html" %>
<link rel="stylesheet" href="css/style.css">
</head>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Riepilogo carrello</h3>
	</div>
<%-- 	<p>Totale carrello: <%=String.format(
			"%.2f", carrello.totaleComplessivo())%>&euro;	
	</p> --%>
	<div class="table-responsive">
		<table class="table table-hover" style="width:100%;">
			<thead>
				<tr>
					<th style="200px;">Nome</th>
					<th style="200px;">Inizio</th>
					<th style="200px;">Fine</th>
					<th style="200px;">Prezzo</th>
					<th style="200px;">Rimuovi</th>
				</tr>
			</thead>
			<tbody>
		<%
			Enumeration<String[]> prodotti = carrello.datiCarrello();
			while(prodotti.hasMoreElements()){
				String[] corso = prodotti.nextElement();
		%>
			<tr>
				<td><%= corso[0] %></td>
				<td><%= corso[1] %></td>
				<td><%= corso[2] %></td>
				<td><%= corso[3] %></td>
				<!-- <td><%-- <%= String.format(
						"%.2f",carrello.totaleParziale(corso[0])) %>&euro; --%></td> -->
				<td>
				<form action="/<%=application.getServletContextName()%>/rimuovi?nome=<%=corso[0] %>" 
				method="post">
				<button type="submit" class="btn btn-danger btn-xs">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
				</form>
				</td>	
			</tr>
		<%
			}
		%>
		</tbody>
		</table>
	</div>
	<hr>
	<a href="sceltacorso.jsp">Torna alla pagina degli acquisti</a>
	<%
		System.out.println(carrello.totaleCorsi() + "nella jsp");
		if(carrello.totaleCorsi() != 0){
	%>
	<div class="panel panel-success" style="margin-top:50px;">
	<div class="panel-heading"><h5>Conferma ordine</h5></div>
	<div class="panel-body">
		<form action="/<%=application.getServletContextName()%>/conferma"
		method="post">
			<button type="submit" class="btn btn-success">
				&#10003;
			</button>
		</form>
	</div>
	</div>
	<%
		}
	%>
	<div id="push"></div>
</div>
<%@include file="footer.html" %>
</body>
</html>
<%
	}
%>
