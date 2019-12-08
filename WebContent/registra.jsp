<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registrazione utente</title>
<script src="js/convalida.js">
</script>
<%@include file="cdn.html"%>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h1>Inserire i dati per la registrazione</h1>
		</div>

		<form action="salvadati.jsp" method="post" id="userForm"
			class="form-horizontal"
			onsubmit="javascript:return checkRegistrazione()">

			<!---------------------------------Nome -->
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<input id="nome" name="nome" placeholder="Nome..."
						class="form-control" type="text">
				</div>
				<div class="col-md-7 control-label" id="infoNome"
					style="text-align: left; color: red"></div>
			</div>

			<!---------------------------------Username-->
			<div class="form-group">
				<label class="col-md-1 control-label">Username</label>
				<div class="col-md-4 inputGroupContainer">
					<input id="username" name="username" placeholder="Username..."
						class="form-control" type="text">
				</div>
				<div class="col-md-7 control-label" id="infoUsername"
					style="text-align: left; color: red"></div>
			</div>

			<!---------------------------------Password-->
			<div class="form-group">
				<label class="col-md-1 control-label">Password</label>
				<div class="col-md-4 inputGroupContainer">
					<input id="password" name="password" placeholder="Password..."
						class="form-control" type="password">
				</div>
				<div class="col-md-7 control-label" id="infoPassword"
					style="text-align: left; color: red"></div>
			</div>

			<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<button type="submit" class="btn btn-warning">
						Registrati <span class="glyphicon glyphicon-send"> </span>
					</button>
				</div>
			</div>
		</form>
		<div id="push"></div>
	</div>
	<%@include file="footer.html"%>
</body>
</html>
