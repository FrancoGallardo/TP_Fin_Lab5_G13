<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/Login.css" type="text/css"><link>
<jsp:include page="Login.jsp" />
<title>Iniciar sesión</title>
</head>
<body>
	<div class="title-container">
	<h1>Iniciar sesión:</h1>
	</div>
	<div class="form-container">
	<form action="Login.do" method="post">
		<div id="divPadre">
				<label for="txtUsuario">Usuario :</label>
				<input id="txtUsuario" name="txtUsuario" type="text" placeholder="Usuario"/>
				<label for="txtContrasenia">Contraseña :</label>
				<input id="txtContrasenia" name="txtContrasenia" type="password" placeholder="Contraseña"/>
				<input id="btnAceptar" type="button" value="Aceptar"/>
				${Msg} 
		</div>
	</form>
	</div>
	<div class="options-container">
	<a href="forgotPassword.do">Cambiar Contraseña</a>
	<a href="register.do">Registrarse</a>
	</div>
</body>
</html>