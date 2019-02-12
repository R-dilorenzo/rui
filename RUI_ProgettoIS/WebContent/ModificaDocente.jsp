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
	<% if (request.getAttribute("RicAvv") == null || request.getAttribute("RicPren") == null){
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ControlProfiloDocente");
    requestDispatcher.forward(request, response); }%>

	<% ArrayList<Avviso> av = (ArrayList<Avviso>) request.getAttribute("RicAvv");%>
	<% ArrayList<Prenotazione> pren = (ArrayList<Prenotazione>) request.getAttribute("RicPren");%>
	<%Docente docente = (Docente) request.getSession().getAttribute("Docente");%>
	<%Date oggi = new Date();SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");%>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="main">
		<h1>
			<%=  docente.getNome() %>
			<%= docente.getCognome() %>
		</h1>
		<br>
		<div>
			<div class=imgbox>
				<img src="<%=docente.getImagePath() %>"
					style="width: 200px; height: 250px;">
			</div>
			<div style="float: left">
				<b>Insegnamento/i :</b>
			</div>
			<br>
			<div>
				<%if(docente.getInsegnamento1() !=null){ %><%=docente.getInsegnamento1() %>
				<%}
				else{%>
				insegnamento1 non impostato
				<%} %>
				<button id="Binsegnamento1" type="button">Modifica</button>
				<div hidden id="insegnamento1">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="insegnamento1">
						<input type="text" name="dato" required> <input
							type="submit" value="Modifica">
					</form>
				</div>
				<br>
				<%if(docente.getInsegnamento2() !=null){ %><%=docente.getInsegnamento2() %>
				<%}else{%>
				insegnamento2 non impostato
				<%} %>
				<button id="Binsegnamento2" type="button">Modifica</button>
				<div hidden id="insegnamento2">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="insegnamento2">
						<input type="text" name="dato" required> <input
							type="submit" value="Modifica">
					</form>
				</div>
			</div>
			<b>Ufficio: </b><%=docente.getUfficio() %>
			<button id="Bufficio" type="button">Modifica</button>
			<div hidden id="ufficio">
				<form action="ControlModificaDocente" method="post">
					<input type="hidden" name="action" value="ufficio"> <input
						type="text" name="dato" required> <input type="submit"
						value="Modifica">
				</form>
			</div>
			<b>Email: </b><%=docente.getEmail() %>
			<button id="Bemail" type="button">Modifica</button>
			<div hidden id="email">
				<form action="ControlModificaDocente" method="post">
					<input type="hidden" name="action" value="email"> <input
						type="text" name="dato" required> <input type="submit"
						value="Modifica">
				</form>
			</div>
			<br> <b>Password:</b> ******
			<button id="Bpassword" type="button">Modifica</button>
			<div hidden id="password">
				<form action="ControlModificaDocente" method="post">
					<input type="hidden" name="action" value="password"> <input
						type="text" name="dato" required> <input type="submit"
						value="Modifica">
				</form>
			</div>
			<br> <b>Orario di ricevimento: </b>
			<div>
				<%if(docente.getGiornoRicevimento1() !=null){ %>-<%=docente.getGiornoRicevimento1() %>
				<%}
				else{%><b> giorno di ricevimento1 non impostato </b>
				<%} %>
				<button id="BgiornoRicevimento1" type="button">Modifica</button>
				<div hidden id="giornoRicevimento1">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="giornoRicevimento1">
						<select name="dato">
							<option value="Lunedì">Lunedì</option>
							<option value="Martedì">Martedì</option>
							<option value="Mercoledì">Mercoledì</option>
							<option value="Giovedì">Giovedì</option>
							<option value="Venerdì">Venerdì</option>
							<option value="Sabato">Sabato</option>
							<option value="Domenica">Domenica</option>
						</select> <input type="submit" value="Modifica">
					</form>
				</div>
				dalle ore:
				<%if(docente.getOraRicevimento1() != 0.0){ %><%=docente.getOraRicevimento1() %>
				<% } 
				else{%><b> orario di inizio non impostato</b>
				<%} %>
				<button id="BorarioRicevimento1" type="button">Modifica</button>
				<div hidden id="orarioRicevimento1">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="oraRicevimento1">
						<select name="dato">
							<option value="9">9:00</option>
							<option value="10">10:00</option>
							<option value="11">11:00</option>
							<option value="12">12:00</option>
							<option value="13">13:00</option>
							<option value="14">14:00</option>
							<option value="15">15:00</option>
							<option value="16">16:00</option>
							<option value="17">17:00</option>
							<option value="18">18:00</option>
						</select> <input type="submit" value="Modifica">
					</form>
				</div>
				alle ore:
				<%if(docente.getOraRicevimento2() != 0.0){ %><%=docente.getOraRicevimento2() %>
				<% } 
				else{%><b> orario di fine non impostato</b>
				<%} %>
				<button id="BorarioRicevimento2" type="button">Modifica</button>
				<div hidden id="orarioRicevimento2">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="oraRicevimento2">
						<select name="dato">
							<option value="9">9:00</option>
							<option value="10">10:00</option>
							<option value="11">11:00</option>
							<option value="12">12:00</option>
							<option value="13">13:00</option>
							<option value="14">14:00</option>
							<option value="15">15:00</option>
							<option value="16">16:00</option>
							<option value="17">17:00</option>
							<option value="18">18:00</option>
						</select> <input type="submit" value="Modifica">
					</form>
				</div>
				<br>
				<%if(docente.getGiornoRicevimento2() !=null){ %>-<%=docente.getGiornoRicevimento2() %>
				<%}
				else{%><b> giorno di ricevimento2 non impostato</b>
				<%} %>
				<button id="BgiornoRicevimento2" type="button">Modifica</button>
				<div hidden id="giornoRicevimento2">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="giornoRicevimento2">
						<select name="dato">
							<option value="Lunedì">Lunedì</option>
							<option value="Martedì">Martedì</option>
							<option value="Mercoledì">Mercoledì</option>
							<option value="Giovedì">Giovedì</option>
							<option value="Venerdì">Venerdì</option>
							<option value="Sabato">Sabato</option>
							<option value="Domenica">Domenica</option>
						</select> <input type="submit" value="Modifica">
					</form>
				</div>
				dalle ore:
				<%if(docente.getOraRicevimento3() != 0.0){ %><%=docente.getOraRicevimento3() %>
				<% } 
				else{%><b> orario di inzio non impostato</b>
				<%} %>
				<button id="BorarioRicevimento3" type="button">Modifica</button>
				<div hidden id="orarioRicevimento3">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="oraRicevimento3">
						<select name="dato">
							<option value="9">9:00</option>
							<option value="10">10:00</option>
							<option value="11">11:00</option>
							<option value="12">12:00</option>
							<option value="13">13:00</option>
							<option value="14">14:00</option>
							<option value="15">15:00</option>
							<option value="16">16:00</option>
							<option value="17">17:00</option>
							<option value="18">18:00</option>
						</select> <input type="submit" value="Modifica">
					</form>
				</div>
				alle ore:
				<%if(docente.getOraRicevimento4() != 0.0){ %><%=docente.getOraRicevimento4() %>
				<% } 
				else{%><b> orario di fine non impostato</b>
				<%} %>
				<button id="BorarioRicevimento4" type="button">Modifica</button>
				<div hidden id="orarioRicevimento4">
					<form action="ControlModificaDocente" method="post">
						<input type="hidden" name="action" value="oraRicevimento4">
						<select name="dato">
							<option value="9">9:00</option>
							<option value="10">10:00</option>
							<option value="11">11:00</option>
							<option value="12">12:00</option>
							<option value="13">13:00</option>
							<option value="14">14:00</option>
							<option value="15">15:00</option>
							<option value="16">16:00</option>
							<option value="17">17:00</option>
							<option value="18">18:00</option>
						</select> <input type="submit" value="Modifica">
					</form>
				</div>
				<form name="formReg" onsubmit="return validateForm()"
			action="ControlModificaImmagine" method="post"
			enctype="multipart/form-data">
			<div>
				<label class="reg" for="immagine">Immagine:</label>
			</div>
			<div>
				<input class="reg" type="file" id="immagine" name="immagine"
					required>
			</div>
			<div class="row">
				<input class="sButton" type="submit" value="Modifica Immagine">
			</div>
		</form>
			</div>
			<br>
			<br>
			<h2>Avvisi:</h2>
			<table>
				<tr>
					<th>Avviso</th>
					<th>Data</th>
					<th>Ora</th>
				</tr>
				<%
   for(Avviso avv : av) {
   %>
				<tr>
					<td>
						<% if(avv.getNomeAvviso() != null){ %><%=avv.getNomeAvviso() %>
						<%}else{%>--<%}%>
					</td>
					<td>
						<% if(avv.getData() != null){ %><%=avv.getData() %>
						<%}else{%>--<%}%>
					</td>
					<td>
						<% if(avv.getOraAvviso() != 0.0){ %><%=avv.getOraAvviso() %>
						<%}else{%>--<%}%>
					</td>
					<td><form action="ControlSelezioneAvviso" id="formID">
							<input type="hidden" name="id" value="<%=avv.getId() %>">
							<input type="submit" value="Visualizza">
						</form></td>
					<td><form action="ControlEliminaAvviso" id="formID">
							<input type="hidden" name="id" value="<%=avv.getId() %>">
							<input type="submit" value="Eimina">
						</form></td>
				</tr>

				<% } %>
			</table>
			<br>
			<br>
			<button id="but1" type="button">Aggiungi Avviso</button>
			<div hidden id="insertAvv">
				<h2>Aggiungi avviso:</h2>
				<form action="ControlAggiungiAvviso" method="post" id="agg">
					nome Avviso:<input type="text" name="nomeAvviso" /><br> <input
						type=hidden name="oraAvviso"
						value="<%=new SimpleDateFormat("HH.mm").format(Calendar.getInstance().getTime()) %>" />
					<input type="hidden" name="data" value="<%=sdf.format(oggi) %>" />
					descrizione:
					<textarea name="descrizione" rows="4" cols="50"> </textarea>
					<br> <input type="hidden" name="matricolaDocente"
						value="<%=docente.getMatricola() %>" /> <input type="submit"
						value="ESEGUI">
				</form>
				<br>
				<h2>Prenotazioni:</h2>
				<table>
					<tr>
						<th>Ora</th>
						<th>Data</th>
						<th>Studente</th>
					</tr>
					<%
   			for(Prenotazione pre : pren) {
   %>
					<tr>
						<td>
							<% if(pre.getOra() != 0.0){ %><%=pre.getOra() %>
							<%}else{ %> <%} %>
						</td>
						<td>
							<% if(pre.getData() != "NULL"){ %><%=pre.getData() %>
							<%}else{%>--<%}%>
						</td>
						<td>
							<% if(pre.getMatricolaStudente() != null){ %><%=pre.getMatricolaStudente() %>
							<%}else{%>--<%}%>
						</td>
					</tr>
					<% } %>
				</table>
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
				$("#but1").click(function() {
					$("#insertAvv").toggle();
				});
				$("#but2").click(function() {
					$("#deleteAvv").toggle();
				});
				$("#Binsegnamento1").click(function() {
					$("#insegnamento1").toggle();
				});
				$("#Binsegnamento2").click(function() {
					$("#insegnamento2").toggle();
				});
				$("#Bemail").click(function() {
					$("#email").toggle();
				});
				$("#Bpassword").click(function() {
					$("#password").toggle();
				});
				$("#BgiornoRicevimento1").click(function() {
					$("#giornoRicevimento1").toggle();
				});
				$("#BorarioRicevimento1").click(function() {
					$("#orarioRicevimento1").toggle();
				});
				$("#BorarioRicevimento2").click(function() {
					$("#orarioRicevimento2").toggle();
				});
				$("#BgiornoRicevimento2").click(function() {
					$("#giornoRicevimento2").toggle();
				});
				$("#BorarioRicevimento3").click(function() {
					$("#orarioRicevimento3").toggle();
				});
				$("#BorarioRicevimento4").click(function() {
					$("#orarioRicevimento4").toggle();
				});
				$("#Bufficio").click(function() {
					$("#ufficio").toggle();
				});
			});
		</script>
</body>
</html>
