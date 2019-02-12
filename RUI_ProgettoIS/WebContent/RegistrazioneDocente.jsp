<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.GestioneAutenticazione.*"%>
<%@page import="Model.GestionePrenotazione.*"%>
<%@page import="Model.GestioneAvviso.*"%>
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
		var matricola = document.forms["formReg"]["matricolaDocente"].value;
		var password = document.forms["formReg"]["password"].value;
		var nome = document.forms["formReg"]["nome"].value;
		var cognome = document.forms["formReg"]["cognome"].value;
		var mail = document.forms["formReg"]["email"].value;
		var mailformat = /^\w+([\.-]?\w+)*@\w+(.unisa.it)+$/;

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

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div id="finestra" title="Errore" style="display: none;"></div>
	<%if (request.getAttribute("ERROR") != null) {%>
	<script> document.getElementById("finestra").innerHTML = "La matricola o l'email inserita è gia in uso da un altro utente"
	
		$(document).ready(function() {
			 $('#finestra').dialog("open");
		});
	</script>
	<%} %>
	<div class="row">

		<div class="main"
			style="background: url(img/reg.png) no-repeat; background-size: cover">
			<div class="login-box">
				<h1>Registrazione</h1>
				<form name="formReg" onsubmit="return validateForm()" action="ControlRegistrazioneDocente" method="post">
					<input type="hidden" name="docente" value="docente" required>
					<div class="textbox">
						<input type="text" placeholder="Nome*" name="nome" value="" required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Cognome*" name="cognome" value="" required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Matricola*"
							name="matricolaDocente" value="" required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Email*" name="email" value="" required>
					</div>
					<div class="textbox">
						<i class="fa fa-lock" aria-hidden="true"></i> <input type="password"
							placeholder="Password*" name="password" value="" required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Insegnamento1*"
							name="insegnamento1" value="" required>
					</div>
					<div class="textbox">
						<input type="text" placeholder="Insegnamento2"
							name="insegnamento2" value="">
					</div>

					<input class="btn" type="submit" name="" value="Registrati">
				</form>
			</div>
		</div>

	</div>
	<div class="footer"></div>

</body>
</html>
