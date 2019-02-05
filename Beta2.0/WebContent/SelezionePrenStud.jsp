<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.*"%>
<%@page import="Controller.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/submit.css">
<link rel="stylesheet" type="text/css" href="css/input.css">
<link rel="stylesheet" type="text/css" href="css/HP.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
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
		Prenotazione prenotazione = (Prenotazione) request.getAttribute("Pren");
	%>
	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>


	<div class="main">
	
	<%
		if (request.getSession().getAttribute("Docente") != null) {
		%>
		<div class="main">
			<div style="text-align: center">
				<h2> Matricola: <%= prenotazione.getMatricolaStudente()%>
					 Data: <%= prenotazione.getData() %>
					 Ora: <%= prenotazione.getOra()%></h2>
			</div>
			<div style="text-align: center">
				<%=prenotazione.getDescrizione()%>
			</div>
			<%
				}
		 else { %>
	
		<h2><%=prenotazione.getCognomeDocente()%>
			<%=prenotazione.getNomeDocente()%></h2>
		<br> La data della prenotazione è:<b><%=prenotazione.getData()%></b>
		alle ore: <b><%=prenotazione.getOra()%></b><br> Descrizione:<b><%=prenotazione.getDescrizione()%></b>

		<button id="Bdescrizione" type="button">Modifica</button>
		<div hidden id="descrizione">
			<form action="ControlModificaPrenotazione" method="post">
				<input type="hidden" name="action" value="descrizione"> <input
					type="hidden" name="id" value="<%=prenotazione.getId()%>">
				<textarea name="dato" rows="4" cols="50"> </textarea>
				<input type="submit" value="Modifica">
			</form>
		<%} %>
		</div>
		<br>
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
			$("#Bdata").click(function() {
				$("#data").toggle();
			});
			$("#Bora").click(function() {
				$("#ora").toggle();
			});
			$("#Bdescrizione").click(function() {
				$("#descrizione").toggle();
			});
		});
	</script>
</body>
</html>
