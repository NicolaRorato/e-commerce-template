<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="background-color: black;">
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="cdn.html"%>
<link rel="stylesheet" href="css/style.css">
</head>
<body style="background-color: black;">
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3 style="color: white; text-align: center;"><img src="img/logo.png" alt="Logo" style="width:110px;"></h3>
		</div>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="img/1.jpg" alt="Immagine1">
				</div>

				<div class="item">
					<img src="img/2.jpg" alt="Immagine2">
				</div>

				<div class="item">
					<img src="img/3.jpg" alt="Immagine3">
				</div>

				<div class="item">
					<img src="img/4.jpg" alt="Immagine4">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
		<div id="push"></div>
	</div>
	<%@include file="footer.html"%>
</body>
</html>