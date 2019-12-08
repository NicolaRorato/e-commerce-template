<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="com.nic.businesscomponent.beans.ReportUtilities"%>
<%@page import="java.util.Enumeration"%>
<%
	String user = (String) session.getAttribute("username");
	if (user == null) {
%>
<%@include file="accessonegato.jsp"%>
<%
	} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <jsp:useBean id="order" class="com.nic.businesscomponent.OrdineBC"
	scope="page" /> --%>
<jsp:useBean id="report"
	class="com.nic.businesscomponent.beans.ReportUtilities" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corsi Utente</title>
<%@include file="cdn.html"%>
<link rel="stylesheet" type="text/css" href="css/stylerating.css">
</head>
<jsp:include page="nav.jsp" />
<div class="container">
	<div class="page-header">
		<h3>Corsi Utente</h3>
	</div>
	<div class="table-responsive">
		<table class="table table-hover" style="width: 100%;">
			<thead>
				<tr>
					<th style="">Id</th>
					<th style="">Nome</th>
					<th style="">Docente</th>
					<th style="">Aula</th>
					<th style="">Data Inizio</th>
					<th style="">Data Fine</th>
					<th style="">Prezzo</th>
					<th style="">Recensisci</th>
					<th style="">Cancella</th>
				</tr>
			</thead>
			<tbody>
				<%
					Date inizio;
						Date fine;
						Double prezzo;
						Vector<String[]> dati = report.getReport(user);
						for (int i = 0; i < dati.size(); i++) {
							String[] corso = dati.get(i);
							SimpleDateFormat inputFormato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
							SimpleDateFormat outputFormato = new SimpleDateFormat("dd-MM-yyyy");
							System.out.println(corso[4] + corso[5]);
							inizio = inputFormato.parse(corso[4]);
							fine = inputFormato.parse(corso[5]);
							System.out.println(inizio);
							prezzo = Double.parseDouble(corso[6]);
				%>

				<tr>
					<td><%=corso[0]%></td>
					<td><%=corso[1]%></td>
					<td><%=corso[2]%></td>
					<td><%=corso[3]%></td>
					<td><%=outputFormato.format(inizio)%></td>
					<td><%=outputFormato.format(fine)%></td>
					<td><%=String.format("%.2f", prezzo)%>&euro;</td>
					<td>
						<form
							action="/<%=application.getServletContextName()%>/recensisci?nome=<%=corso[1]%>"
							method="post">
							<input type="hidden" name="nome" value="<%=corso[1]%>">
							<input type="radio" name="stelle" value="1"> <input
								type="radio" name="stelle" value="2"> <input type="radio"
								name="stelle" value="3"> <input type="radio" name="stelle"
								value="4"> <input type="radio" name="stelle" value="5">
							<input type="submit" value="Submit">
						</form>
					</td>
					<td>
						<form
							action="/<%=application.getServletContextName()%>/rimuoviregistrazione?id_registrazione=<%=corso[0]%>"
							method="post">
							<button type="submit" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-remove"></span>
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
	<%
		}
	%>
	<div id="push"></div>
</div>
<%@include file="footer.html"%>
</body>
</html>