<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.GestioneAutenticazione.*"%>
<%@page import="Model.GestionePrenotazione.*"%>
<%@page import="Model.GestioneAvviso.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/submit.css">
<link rel="stylesheet" type="text/css" href="css/HP.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<div class="header">
		<div>
			<img src="img/rui.png" style="width: 250px; height: 150px;"
				alt="immagine non trovata">
			<div style="float: right">
				<img class="logo" src="img/logo_standard.png"
					style="width: 150px; height: 150px;" alt="immagine non trovata">
			</div>
		</div>
	</div>
	<div class="navbar">
		<a href="Home.jsp">Home</a>
		<%
			if (session.getAttribute("Docente") == null && session.getAttribute("Studente") == null) {
		%>
		<a href="Login.jsp" style="float: right">Login</a>
		<div class="dropdown" style="float: right">
			<button class="dropbtn">
				Registrati <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="RegistrazioneStudente.jsp">Registrazione Studente</a> <a
					href="RegistrazioneDocente.jsp">Registrazione Docente</a>
			</div>
		</div>


		<%
			} else {
				if (request.getSession().getAttribute("Docente") != null) {
					Docente docente = (Docente) request.getSession().getAttribute("Docente");
		%>
		<a href="ControlProfiloDocente?" class="right">Modifica Account</a> <a
			href="ControlLogout?" class="right">Logout</a> <a
			href="ControlRicercaDocente?matricolaDocente=<%=docente.getMatricola()%>">Area
			Personale: <%=docente.getNome()%></a>
		<%
			} else if (request.getSession().getAttribute("Studente") != null) {
					Studente studente = (Studente) request.getSession().getAttribute("Studente");
		%>
		<a href="ControlProfiloStudente?" class="right">Modifica Account</a> <a
			href="ControlLogout?" class="right">Logout</a>
		<%
			}
			}
		%>
	</div>


</body>
</html>