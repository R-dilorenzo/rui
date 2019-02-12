<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.GestioneAutenticazione.*"%>
<%@page import="Model.GestionePrenotazione.*"%>
<%@page import="Model.GestioneAvviso.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/Search.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.12.1/jquery-ui.custom.min.js"></script>
<link href="jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- navbar -->
	<jsp:include page="Navbar.jsp"></jsp:include>

	<div class="row">
	
	<%if (request.getAttribute("loginError") != null) {%>
	<script type="text/javascript">
    $(document).ready(function(){
     
        $('#finestra').dialog({
            modal: true,
            autoOpen: false,
            buttons: {
                "OK": function() {
                    $( this ).dialog( "close" );
                    }
                }
            });
        
        $('#finestra').dialog("open");
        });
	</script>
	<% } %>
	
	<div id="finestra" title="Errore" style="display: none;">
     <p> Campo <strong>e-mail</strong> o <strong>password</strong> non corretti </p>
	</div>
	
		<div class="main"
			style="background: url(img/inf.png) no-repeat; background-size: cover">
			<div class="login-box">
				<h1>Login</h1>
				<form action="ServletLogin" method="post">
					<input type="hidden" name="studente" value="studente">
					<div class="textbox">
						<i class="fa fa-user" aria-hidden="true"></i> <input type="text"
							placeholder="Email" name="email" value="" required>
					</div>

					<div class="textbox">
						<i class="fa fa-lock" aria-hidden="true"></i> <input type="password"
							placeholder="Password" name="password" value="" required>
					</div>

					<input class="btn" type="submit" name="" value="Login">
				</form>
			</div>
		</div>

	</div>
	<div class="footer"></div>
</body>
</html>
