<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.GestioneAutenticazione.*"%>
<%@page import="Model.GestionePrenotazione.*"%>
<%@page import="Model.GestioneAvviso.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/submit.css">
<link rel="stylesheet" type="text/css" href="css/HP.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
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
		Docente docente = (Docente) request.getSession().getAttribute("Docente");
	%>
	<%
		Avviso avv = (Avviso) request.getAttribute("Avv");
	%>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="row">
		<%
			if (docente != null && docente.getMatricola().equals(avv.getMatricolaDocente())) {
		%>
		<table>
			<tr>
				<th>NomeAvviso:</th>
				<td><%=avv.getNomeAvviso()%></td>
				<td>
					<form action="ControlModificaAvviso" method="post">
						<input type="hidden" name="action" value="nomeAvviso"> <input
							type="hidden" name="id" value="<%=avv.getId()%>"> <input
							type="text" name="dato" required> <input type="submit"
							value="Modifica">
					</form>
				</td>
			</tr>
			<tr>
				<th>Descrizione:</th>
				<td><%=avv.getDescrizione()%></td>
				<td>
					<form action="ControlModificaAvviso" method="post">
						<input type="hidden" name="action" value="descrizione">
						<textarea name="dato" rows="4" cols="50" required></textarea>
						<input type="hidden" name="id" value="<%=avv.getId()%>"> <input
							type="submit" value="Modifica">
					</form>
				</td>
			</tr>
		</table>
		<%
			} else {
		%>
		<div class="main">
			<div style="text-align: center">
				<h2><%=avv.getNomeAvviso()%></h2>
			</div>
			<div style="text-align: center">
				<%=avv.getDescrizione()%>
			</div>
			<%
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
