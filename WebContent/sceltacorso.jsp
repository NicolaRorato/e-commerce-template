<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nic.businesscomponent.CorsoBC"%>
<%@page import="com.nic.businesscomponent.beans.Corso"%>
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
<title>Scelta corsi</title>
<%@include file="cdn.html" %>
<link rel="stylesheet" href="css/style.css">
</head>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Scegli dalla lista dei corsi</h3>
	</div>
<%-- 	<p>Totale carrello: <%=String.format(
			"%.2f", carrello.totaleComplessivo())%>&euro;	
	</p> --%>
	<div class="table-responsive">
		<table class="table table-hover" style="width:100%;">
			<thead>
				<tr> 
					<th style="width:200px;">Nome</th>
					<th style="width:200px;">Docente</th>
					<th style="width:200px;">Aula</th>
					<th style="width:200px;">Data Inizio</th>
					<th style="width:200px;">Data Fine</th>
					<th style="width:200px;">Prezzo</th>
				</tr>
			</thead>
			<tbody> <!-- body of the table -->
				<%
					Corso[] a = CorsoBC.getFactory().getCorsi();
					for(int i = 0; i<a.length;i++){
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				%>
				<tr>
				<td><%= a[i].getNome() %></td>
				<td><%= a[i].getDocente() %></td>
				<td><%= a[i].getAula() %></td>
				<td><%= formato.format(a[i].getInizio()) %></td>
				<td><%= formato.format(a[i].getFine()) %></td>
				<td><%= String.format("%.2f", a[i].getPrezzo())%>&euro;</td>
				<td>
				<form action="/<%=application.getServletContextName()%>/aggiungi"
				method="post">
				<input type="hidden" name="nome" value="<%= a[i].getNome()%>">
				<input type="hidden" name="inizio" value="<%= formato.format(a[i].getInizio())%>">
				<input type="hidden" name="fine" value="<%= formato.format(a[i].getFine())%>">
				<input type="hidden" name="prezzo" value="<%= a[i].getPrezzo()%>">	
				<button type="submit" class="btn btn-primary btn-xs">
					Aggiungi
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
	<a href="visualizza.jsp">Riepilogo carrello</a>
	<div id="push"></div>
</div>
<%@include file="footer.html" %>
</body>
</html>
<%
	}
%>
