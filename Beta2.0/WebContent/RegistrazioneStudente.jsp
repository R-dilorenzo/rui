<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.*"%>
<%@page import="Controller.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.12.1/jquery-ui.custom.min.js"></script>
<link href="jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
<script>
	function validateForm() {
		var finestra = document.getElementById("finestra");
		var matricola = document.forms["formReg"]["matricolaStudente"].value;
		var password = document.forms["formReg"]["password"].value;
		var nome = document.forms["formReg"]["nome"].value;
		var cognome = document.forms["formReg"]["cognome"].value;
		var mail = document.forms["formReg"]["email"].value;
		var mailformat = /^\w+([\.-]?\w+)*@\w+(.unisa.it)+$/;
		var xhttp = new XMLHttpRequest();

		if (matricola.length != 10) {
			finestra.innerHTML = "Matricola non corretta";
			return false;
		} else if (password.length < 8) {
			finestra.innerHTML = "Password non corretta";
			return false;
		} else if (!mail.match(mailformat)) {
			finestra.innerHTML = "Mail non corretta";
			return false;
		} else {
			return true;
		}
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#finestra').dialog({
			modal : true,
			autoOpen : false,
			buttons : {
				"OK" : function() {
					$(this).dialog("close");
				}
			}
		});

		$('#finestra').bind("DOMSubtreeModified", function() {
			$('#finestra').dialog("open");
		});
	});
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="finestra" title="Errore" style="display: none;"></div>
	<%if (request.getAttribute("ERROR") != null) {%>
	<script> document.getElementById("finestra").innerHTML = "La matricola o l'email inserita � gia in uso da un altro utente"
	
		$(document).ready(function() {
			 $('#finestra').dialog("open");
		});
	</script>
	<%} %>
	
	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="row">

		<div class="main"
			style="background: url(img/reg.png) no-repeat; background-size: cover">
			<div class="login-box">
				<h1>Registrazione</h1>
				<form name="formReg" onsubmit="return validateForm()" action="ControlRegistrazioneStudente" method="post">
					<input type="hidden" name="studente" value="studente" required>
					<div class="textbox">
						<input type="text" placeholder="Nome" name="nome" value=""
							required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Cognome" name="cognome" value=""
							required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Email" name="email" value=""
							required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Matricola"
							name="matricolaStudente" value="">
					</div>
					<div class="textbox">
						<input type="password" placeholder="Password" name="password" value=""
							required>
					</div>

					<input class="btn" id="sub" type="submit" name=""
						value="Registrati">
				</form>
			</div>
		</div>

	</div>
	<div class="footer"></div>

</body>
</html>
