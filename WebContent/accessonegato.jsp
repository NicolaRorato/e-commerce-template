<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ include file="cdn.html"%>

<title>Accesso negato!</title>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<div class="container">
		<!-- container è una classe inclusa in bootstrap, aiuta a disporre gli elementi -->
		<div class="page-header">
			<h3>Non puoi accedere a questa pagina</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Risorsa non disponibile</h3>
			</div>
			<div class="panel-body">
				<p>Per accedere alla pagina:</p>
				<p>
					Effettuare la registrazione: <a href="registra.jsp">Sign-up</a>
				</p>
				<p>
					Oppure effettuare il login se registrati: <a href="login.jsp">Login</a>
				</p>
			</div>
		</div>
		<div id="push"></div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>