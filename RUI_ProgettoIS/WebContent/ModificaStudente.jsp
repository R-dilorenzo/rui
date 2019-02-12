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
<link rel="stylesheet" type="text/css" href="css/input.css">
<link rel="stylesheet" type="text/css" href="css/HP.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
<link rel="stylesheet" type="text/css" href="css/submit.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.imgbox {
	float: left;
	text_align: center;
	width: 160px;
	height: 350px;
	border: 1px;
	margin: 4px;
	padding: 6px;
	height: auto;
}

img {
	max-width: 100%;
	height: auto;
}

table, td {
	border: 1px solid #284b6e;
	float: center;
}
</style>
</head>
<body>
	<%
		if (request.getAttribute("RicPren") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ControlProfiloStudente");
			requestDispatcher.forward(request, response);
		}
	%>
	<%
		ArrayList<Prenotazione> pren = (ArrayList<Prenotazione>) request.getAttribute("RicPren");
	%>
	<%
		Studente studente = (Studente) request.getSession().getAttribute("Studente");
	%>
	<%
		ArrayList<Docente> LH = (ArrayList<Docente>) request.getAttribute("LH");
	%>
	<%
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="row">

		<div class="main">
			<h1><%=studente.getNome()%>
				<%=studente.getCognome()%></h1>
			Email:<%=studente.getEmail()%>
			<button id="Bemail" type="button">Modifica</button>
			<div hidden id="email">
				<form action="ControlModificaStudente" method="post">
					<input type="hidden" name="action" value="email"> <input
						type="text" name="dato" required> <input type="submit"
						value="Modifica">
				</form>
			</div>
			<br> Matricola:<%=studente.getMatricola()%><br> Password:<%=studente.getPassword()%>
			<button id="Bpassword" type="button">Modifica</button>
			<div hidden id="password">
				<form action="ControlModificaStudente" method="post">
					<input type="hidden" name="action" value="password"> <input
						type="text" name="dato" required> <input type="submit"
						value="Modifica">
				</form>
			</div>
			<br> <br>
			<h2>Prenotazioni:</h2>
			<table>
				<tr>
					<th>Ora</th>
					<th>Data</th>
					<th>Docente</th>
				</tr>
				<%
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					String inActiveDate = null;
					inActiveDate = sdf.format(date);
					for (Prenotazione pre : pren) {
						if (pre.getData().compareTo(inActiveDate) >= 0) {
				%>
				<tr>
					<td>
						<%
							if (pre.getOra() != 0.0) {
						%><%=pre.getOra()%>
						<%
							} else {
						%> <%
 	}
 %>
					</td>
					<td>
						<%
							if (pre.getData() != "NULL") {
						%><%=pre.getData()%>
						<%
							} else {
						%>--<%
							}
						%>
					</td>
					<td>
						<%
							if (pre.getNomeDocente() != null) {
						%><%=pre.getNomeDocente()%>
						<%
							} else {
						%>--<%
							}
						%> <%
 	if (pre.getCognomeDocente() != null) {
 %> <%=pre.getCognomeDocente()%>
						<%
							} else {
						%>--<%
							}
						%>
					</td>
					<td><form action="ControlSelezionePrenotazione" id="formID">
							<input type="hidden" name="id" value="<%=pre.getId()%>">
							<input type="submit" value="Visualizza">
						</form></td>
					<td><form action="ControlEliminaPrenotazione" id="formID">
							<input type="hidden" name="id" value="<%=pre.getId()%>">
							<input type="submit" value="ELIMINA">
						</form></td>
				</tr>
				<%
					}
					}
				%>
			</table>


			<br>
			<br>
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

		//script per form nascosta
		$(document).ready(function() {
			$("#Bemail").click(function() {
				$("#email").toggle();
			});
			$("#Bpassword").click(function() {
				$("#password").toggle();
			});
			$("#but2").click(function() {
				$("#deletePren").toggle();
			});
		});
	</script>
</body>
</html>
