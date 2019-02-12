<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.GestioneAutenticazione.*"%>
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
	<%
		if (request.getAttribute("LH") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ControlElencoDocenti");
			requestDispatcher.forward(request, response);
		}
		ArrayList<Docente> LH = (ArrayList<Docente>) request.getAttribute("LH");
	%>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="row">
		<div class="side">
			<h2 style="color: white">Ricerca Docenti</h2>

			<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for names.." title="Type in a name">

			<ul id="myUL">
				<%
					for (Docente p : LH) {
						System.out.println(p.getMatricola());
				%>
				<li><a
					href="ControlRicercaDocente?matricolaDocente=<%=p.getMatricola()%>"><%=p.getCognome()%>
						<%=p.getNome()%></a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="main">
			<h1>
				Benvenuto su <b>Ricevimento Unisa Informatica</b>
			</h1>
			<%
				if (session.getAttribute("docente") == null && session.getAttribute("studente") == null) {
			%>
			Puoi Visualizzare le informazioni di un docente scegliendo dalla
			sezione <b>Ricerca Docente</b> il docente interessato <br>
			oppure effettuare il <b>Login</b> e <b>Registrazione</b> dalla barra
			di navigazione.
			<%
				} else {
					if (request.getSession().getAttribute("Docente") != null) {
						Docente docente = (Docente) request.getSession().getAttribute("Docente");
			%>
			Scegli dalla barra di navigazione <b>info </b> per visualizzare la
			tua pagina personale<br> <br> Puoi modificare le tue
			informazioni attraverso <b>Gestione Account</b> sempre nella barra di
			navigazione
			<%
 	} else {

 			Studente studente = (Studente) request.getSession().getAttribute("Studente");
 %>
			Per effettuare una prenotazione scegli un docente dalla sezione <b>Ricerca
				Docente</b>.<br> <br> Scegli dalla barra di navigazione <b>info
				<%=studente.getNome()%></b> per visualizzare la tua pagina personale<br>
			Puoi modificare le tue informazioni o eliminare e modificare una
			prenotazione attraverso <b>Gestione Account</b> sempre nella barra di
			navigazione
			<%
 	}
 	}
 %>

		</div>
	</div>

	<div class="footer"></div>


	<script>
		//script per search
		function myFunction() {
			var input, filter, ul, li, a, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			ul = document.getElementById("myUL");
			li = ul.getElementsByTagName("li");
			for (i = 0; i < li.length; i++) {
				a = li[i].getElementsByTagName("a")[0];
				txtValue = a.textContent || a.innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1) {
					li[i].style.display = "";
				} else {
					li[i].style.display = "none";
				}
			}
		}
	</script>
</body>
</html>
