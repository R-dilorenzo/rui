<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.GestioneAutenticazione.*"%>
<%@page import="Model.GestionePrenotazione.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/submit.css">
<link rel="stylesheet" type="text/css" href="css/HP.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
<link rel="stylesheet" type="text/css" href="css/mese.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<%
		ArrayList<Prenotazione> pren = (ArrayList<Prenotazione>) request.getAttribute("RicPren");
	%>
	<%
		int mese = Integer.parseInt(request.getParameter("mese"));
	%>

	<%
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		int year = calendar.get(Calendar.YEAR);
	%>


	<table class="TABLEmese" style="float: center" name="mese">

		<%
			calendar.set(year, mese, 1);
			int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
			int currentDay = 1;
		%>

		<caption id="nomeMese">
			<%
				switch (mese) {
				case 0:
			%>
			Gennaio
			<%
				break;
				case 1:
			%>
			Febbraio
			<%
				break;
				case 2:
			%>
			Marzo
			<%
				break;
				case 3:
			%>
			Aprile
			<%
				break;
				case 4:
			%>
			Maggio
			<%
				break;
				case 5:
			%>
			Giugno
			<%
				break;
				case 6:
			%>
			Luglio
			<%
				break;
				case 7:
			%>
			Agosto
			<%
				break;
				case 8:
			%>
			Settembre
			<%
				break;
				case 9:
			%>
			Ottobre
			<%
				break;
				case 10:
			%>
			Novembre
			<%
				break;
				case 11:
			%>
			Dicembre
			<%
				break;
				}
			%>
		</caption>
		<col class="weekend">
		<col class="weekday" span="5">
		<col class="weekend">
		<thead>
			<tr>
				<th class="THmese">Domenica</th>
				<th class="THmese">Lunedì</th>
				<th class="THmese">Martedì</th>
				<th class="THmese">Mercoledì</th>
				<th class="THmese">Giovedì</th>
				<th class="THmese">Venerdì</th>
				<th class="THmese">Sabato</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
			%><tr>
				<%
					for (; i < firstDay; i++) {
				%>
				<td class="TDmese"><div class="day"></div></td>
				<%
					}
				%>

				<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = null;         
			 		String inActiveDate = null;
					
					while (true) {
						for (; i <= 7; i++) {
							calendar.set(year, mese, currentDay);
							date = calendar.getTime(); 
							inActiveDate = sdf.format(date);
				%>
				<td class="TDmese"><div class="day"><%=currentDay%></div> <%
 					for (Prenotazione pre : pren) {
						if (pre.getData().equals(inActiveDate)) {
					%>Studente:<%=pre.getMatricolaStudente()%>-<%=pre.getOra()%><br>
					<%
						}
					%>
					<%
						}
					%> <%
 	currentDay++;
 			if (currentDay > maxDay)
 				break;
 		}

 		if (currentDay > maxDay)
 			break;
 %>
			</tr>
			<%
				i = 1;
				}

				for (; i < 7; i++) {
			%>
			<td class="TDmese"><div class="day"></div></td>
			<%
				}
			%>

			</tr>
		</tbody>
	</table>

</body>
</html>