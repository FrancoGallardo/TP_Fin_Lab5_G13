<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/Menu.css">
<link rel='stylesheet'
	href='<%=org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>'>
<link rel='stylesheet'
	href='<%=org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css")%>'>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js")%>'></script>
<link rel='stylesheet'
	href='<%=org.webjars.AssetLocator.getWebJarPath("css/font-awesome.min.css")%>'>


<title>${PageTitle}</title>
</head>

<body>
	<header class="header-container">
	<div class="container">
		<div class="row header-row">
			<div class="col-sm-3">
				<img src="Assets/img/logo-utn.png" alt="logo">
			</div>
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<ul class="header-items-container">
					<li><h6>
							<a class="header-nav-anchor" href="redirectLogin.do">Iniciar
								Sesion</a>
						</h6></li>
					<li class="transfer-nav-item"><h6>
							<a class="header-nav-anchor" href="redirectRegister.do">Registrarse</a>
						</h6></li>
					<li><h6>
							<a class="header-nav-anchor" href="redirectForgotPassword.do">Cambiar
								Contraseņa</a>
						</h6></li>
				</ul>
			</div>
		</div>
	</div>
	</header>
	<div class="main-container">
		<div class="container">
		<div class="row title-row-container">
			<div class="icon-container">
					<i class="fa fa-university bank-icon" aria-hidden="true"></i>
					</div>
								<div class="col-sm-11">
				<div class="home-title-container title-container">
					<h1>Banco UTN</h1>
				</div>
			</div>
			</div>	
			<div class="row index-content-row">
				<div class="col-sm-6">
					<p>Quis tristique ultrices a aenean conubia in, nullam quam
						sollicitudin senectus sociis sed vivamus, penatibus convallis
						platea pretium pharetra. Conubia etiam odio vivamus eros iaculis
						sociis ligula tincidunt, cubilia ante nulla nam ut dictumst primis
						cras, nec litora at hac sem netus accumsan. Risus dignissim in
						natoque enim dictum porttitor massa elementum, nostra vitae odio
						curae vivamus integer ultrices.</p>
				</div>
				<div class="col-sm-6">
					<div class="row index-right-column-row">
						<div class="col-sm-5">
							<img src="Assets/img/logo-index.png" width="210" alt="index">
						</div>
						<div class="col-sm-7 index-register-column">
						<div style="">
							<h4>Se parte de nuestro emprendimiento</h4>
							<span>Comienza
							<a class="header-nav-anchor"
								href="redirectTransferenciaPropias.do">registrandote</a> para empezar a realizar transferencias
								</span>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer class="footer-container">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 footer-first-column">
					<div>
						<h5>Sobre nosotros</h5>
						<p>Proyecto desarrollado por el grupo 13 de la Universidad
							Tecnologica Nacional (UTN)</p>
					</div>
				</div>
				<div class="col-sm-4 footer-second-column"></div>
				<div class="col-sm-4 footer-third-column">
					<div class="menu-footer-location">
						<i class="fa fa-map-marker footer-icon" aria-hidden="true"></i> <span>Av.
							Hipólito Yrigoyen 288 - Gral. Pacheco (Tigre). 1617</span>
					</div>
					<div class="menu-footer-email">
						<i class="fa fa-envelope-o footer-icon" aria-hidden="true"></i> <span><a
							target="_blank" href="mailto:info@yopmail.com">info@yopmail.com</a></span>
					</div>
					<div class="menu-footer-telephone">
						<i class="fa fa-phone footer-icon" aria-hidden="true"></i> <span><a
							target="_blank" href="tel:45658585">4736-9198</a></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>