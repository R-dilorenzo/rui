<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.*"%>
<%@page import="Controller.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
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
		ArrayList<Avviso> avv = (ArrayList<Avviso>) request.getAttribute("RicAvv");
	%>
	<%
		ArrayList<Prenotazione> pren = (ArrayList<Prenotazione>) request.getAttribute("RicPren");
	%>
	<%
		Docente docente = (Docente) request.getAttribute("Docente");
	%>
	<%
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="row">


		<div class="main">
			<h1>
				<%=docente.getNome()%>
				<%=docente.getCognome()%>
			</h1>
			<br>
			<div>
				<div class=imgbox>
					<img src="<%=docente.getImagePath()%>"
						style="width: 200px; height: 250px;">
				</div>
				<div style="float: left">
					<b>Insegnamento/i: </b>
				</div>
				<div>
					<%
						if (docente.getInsegnamento1() != null) {
					%><%=docente.getInsegnamento1()%>
					<%
						}
					%>
					<%
						if (docente.getInsegnamento2() != null) {
					%>
					e
					<%=docente.getInsegnamento2()%>
					<%
						}
					%>
				</div>
				<b>Ufficio: </b><%=docente.getUfficio()%>
				<b>Email: </b><%=docente.getEmail()%>
				<br>
				<div style="float: left">
					<b>Orario di ricevimento: </b>
				</div>
				<br>
				<div>
					<%
						if (docente.getGiornoRicevimento1() != null) {
					%>-<%=docente.getGiornoRicevimento1()%>
					<%
						}
					%>
					<%
						if (docente.getOraRicevimento1() != 0.0) {
					%>dalle ore:
					<%=docente.getOraRicevimento1()%>
					<%
						}
					%>
					<%
						if (docente.getOraRicevimento2() != 0.0) {
					%>alle ore:
					<%=docente.getOraRicevimento2()%>
					<%
						}
					%>
					<br>
					<%
						if (docente.getGiornoRicevimento2() != null) {
					%>-<%=docente.getGiornoRicevimento2()%>
					<%
						}
					%>
					<%
						if (docente.getOraRicevimento3() != 0.0) {
					%>
					dalle ore:
					<%=docente.getOraRicevimento3()%>
					<%
						}
					%>
					<%
						if (docente.getOraRicevimento4() != 0.0) {
					%>alle ore:<%=docente.getOraRicevimento4()%>
					<%
						}
					%>

					<br> <br> <br> CALENDARIO: 
						<form name="calendarioForm" action="ControlCalendario" method="post">
						<select id="mese" name="mese">
							<option value="">Seleziona Mese</option>
							<option value="0">Gennaio</option>
							<option value="1">Febbraio</option>
							<option value="2">Marzo</option>
							<option value="3">Aprile</option>
							<option value="4">Maggio</option>
							<option value="5">Giugno</option>
							<option value="6">Luglio</option>
							<option value="7">Agosto</option>
							<option value="8">Settembre</option>
							<option value="9">Ottobre</option>
							<option value="10">Novembre</option>
							<option value="11">Dicembre</option>
						</select> <input type="hidden" name="matricolaDocente"
							value="<%=docente.getMatricola()%>"> <input
							type="submit">
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
						if (avv != null) {
							for (Avviso fa : avv) {
					%>
					<tr>
						<td>
							<%
								if (fa.getNomeAvviso() != null) {
							%><%=fa.getNomeAvviso()%>
							<%
								} else {
							%>--<%
								}
							%>
						</td>
						<td>
							<%
								if (fa.getData() != null) {
							%><%=fa.getData()%>
							<%
								} else {
							%>--<%
								}
							%>
						</td>
						<td>
							<%
								if (fa.getOraAvviso() != 0.0) {
							%><%=fa.getOraAvviso()%>
							<%
								} else {
							%>--<%
								}
							%>
						</td>
						<td><form action="ControlSelezioneAvviso" id="formID">
								<input type="hidden" name="id" value="<%=fa.getId()%>">
								<input type="submit" value="Visualizza">
							</form></td>
					</tr>

					<%
						}
						}
					%>
				</table>

				<br>
				<h2>Prenotazioni:</h2>
				<table>
					<tr>
						<th>Ora</th>
						<th>Data</th>
						<th>Studente</th>
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
								if (pre.getMatricolaStudente() != null) {
							%><%=pre.getMatricolaStudente()%>
							<%
								} else {
							%>--<%
								}
							%>
						</td>
						<%
							Docente doc = (Docente) request.getSession().getAttribute("Docente");
									if (doc != null && doc.getMatricola().equals(docente.getMatricola())) {
						%>
						<td><form action="ControlSelezionePrenotazione" id="formID">
								<input type="hidden" name="id" value="<%=pre.getId()%>">
								<input type="submit" value="Visualizza">
								<%
									}
								%>
							</form></td>
					</tr>
					<%
						}
						}
					%>
				</table>
				<br>
				<%
					boolean flag = true;
					Studente studente = (Studente) request.getSession().getAttribute("Studente");
					if (studente != null) {
						for (Prenotazione pre : pren) {
							if (pre.getMatricolaStudente().equals(studente.getMatricola())) {
								flag = false;
								break;
							}
						}
						if (flag) {
				%>
				<button id="BinsertPren" type="button">Aggiungi
					Prenotazione</button>
				<div id="insertPren">
					<h2>Aggiungi Prenotazione:</h2>
					<form name="myForm" action="ControlAggiungiPrenotazione"
						method="post" id="agg">
						seleziona una data:<input type="date" name="data"
							min="<%=sdf.format(oggi)%>" max="2019-12-31" /> e un orario: <select
							id="x" name="ora">
							<%
								double oraInizio1 = docente.getOraRicevimento1();
										double oraFine1 = docente.getOraRicevimento2();
										double oraInizio2 = docente.getOraRicevimento3();
										double oraFine2 = docente.getOraRicevimento4();

										ArrayList<Double> range = new ArrayList<>();
										if ((oraFine1 - oraInizio1) > 1) {
											double diff = oraFine1 - oraInizio1;
											for (int y = 0; y <= diff; y++) {
												range.add(oraInizio1 + y);
											}
										} else {
											range.add(oraInizio1);
											range.add(oraFine1);
										}
										int length = range.size();
							%>
							<option disabled="disabled"><%=docente.getGiornoRicevimento1()%></option>
							<%
								for (int i = 0; i < length; i++) {
							%>
							<option value="<%=range.get(i)%>"><%=range.get(i)%></option>
							<%
								}

										ArrayList<Double> range1 = new ArrayList<>();
										if ((oraFine2 - oraInizio2) > 1) {
											double diff = oraFine2 - oraInizio2;
											for (int y = 0; y <= diff; y++) {
												range1.add(oraInizio2 + y);
											}
										} else {
											range1.add(oraInizio2);
											range1.add(oraFine2);
										}
										int length1 = range1.size();
							%>
							<option disabled="disabled">--------</option>
							<option disabled="disabled"><%=docente.getGiornoRicevimento2()%></option>
							<%
								for (int i = 0; i < length1; i++) {
							%>
							<option value="<%=range1.get(i)%>"><%=range1.get(i)%></option>
							<%
								}
							%>

						</select> <br> Descrizione (opzionale):
						<textarea name="descrizione" rows="4" cols="50"> </textarea>
						<br> <input type="hidden" name="matricolaDocente"
							value="<%=docente.getMatricola()%>" /> <input type="submit"
							value="INVIA">
					</form>

				</div>
				<%
					}
				%>
			</div>
			<form name="myForm1" action="#" method="post">
				<input type="hidden" name="myField1"
					value="<%=docente.getGiornoRicevimento1()%>"> <input
					type="hidden" name="myField2"
					value="<%=docente.getGiornoRicevimento2()%>"> <input
					type="hidden" name="myField3"
					value="<%=docente.getOraRicevimento1()%>"> <input
					type="hidden" name="myField4"
					value="<%=docente.getOraRicevimento2()%>"> <input
					type="hidden" name="myField5"
					value="<%=docente.getOraRicevimento3()%>"> <input
					type="hidden" name="myField6"
					value="<%=docente.getOraRicevimento4()%>">
			</form>
			<%
				}
			%>



		</div>
		<input type="hidden" id="myP"
			value="<%=docente.getGiornoRicevimento1()%>"> <input
			type="hidden" id="myP1"
			value="<%=docente.getGiornoRicevimento2()%>">

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
				$("#BinsertPren").click(function() {
					$("#insertPren").toggle();
				});

			});
		</script>
		<script>
			//funzione per togliere i giorni non consenitit dal calendar
			var date = document.querySelector('[type=date]');

			function noMondays(e) {
				var x = document.getElementById("myP").value;
				var x1 = document.getElementById("myP1").value;

				if (x == "Lunedì") {
					x = 1;
				} else if (x == "Martedì") {
					x = 2;
				} else if (x == "Mercoledì") {
					x = 3;
				} else if (x == "Giovedì") {
					x = 4;
				} else if (x == "Venerdì") {
					x = 5;
				} else if (x == "Sabato") {
					x = 6;
				} else if (x == "Domenica") {
					x = 0;
				}

				if (x1 == "Lunedì") {
					x1 = 1;
				} else if (x1 == "Martedì") {
					x1 = 2;
				} else if (x1 == "Mercoledì") {
					x1 = 3;
				} else if (x1 == "Giovedì") {
					x1 = 4;
				} else if (x1 == "Venerdì") {
					x1 = 5;
				} else if (x1 == "Sabato") {
					x1 = 6;
				} else if (x1 == "Domenica") {
					x1 = 0;
				}
				var day = new Date(e.target.value).getUTCDay();

				if (day != x && day != x1) {

					e.target
							.setCustomValidity('ERRORE: il giorno selezionato non fa parte dei giorni di ricevimento del docente.');

				} else {

					e.target.setCustomValidity('');

				}

			}

			date.addEventListener('input', noMondays);
		</script>
</body>
</html>
