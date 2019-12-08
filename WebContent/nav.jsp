<jsp:useBean id="carrello"
	class="com.nic.businesscomponent.beans.Carrello" scope="session" />
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#mioMenu">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp"><span
				class="glyphicon glyphicon-tower"></span></a>
		</div>

		<div class="collapse navbar-collapse" id="mioMenu">
			<!-- l'id riferisce al data-target sopra -->
			<%
				String user = (String) session.getAttribute("username");
				if (user == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="registra.jsp"> <span
						class="glyphicon glyphicon-user"></span>&nbsp;Sign up
				</a></li>
				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-login"></span>&nbsp;Login
				</a></li>
			</ul>
			<%
				} else {
			%>

			<ul class="nav navbar-nav">
				<li><a href="sceltacorso.jsp"><span
				class="glyphicon glyphicon-ice-lolly"></span> Corsi</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li><a href="corsi.jsp"><span
				class="glyphicon glyphicon-ice-lolly-tasted"></span> I miei corsi</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="visualizza.jsp"> <span
						class="glyphicon glyphicon-shopping-cart"></span>&nbsp;<span
						class="badge"> <%=carrello.totaleCorsi()%>
					</span></a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;
						<%=user%></a></li>
				<li><a href="logout.jsp"><span
						class="glyphicon glyphicon-user"></span>&nbsp; Logout</a></li>
			</ul>
			<%
				}
			%>
		</div>
	</div>
</nav>