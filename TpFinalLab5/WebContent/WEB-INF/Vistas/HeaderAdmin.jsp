<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script>
	$(document).ready(function() {
		$('#bankTable').DataTable({
			"lengthChange" : false,
			"info" : false,
			"pageLength" : 5
		});
	});
</script>
<title>${PageTitle}</title>
</head>

<body>
	<header class="header-container">
	<div class="container">
		<div class="row header-row">
			<div class="col-sm-3">
				<img src="Assets/logo-utn.png" alt="logo">
			</div>
			<div class="col-sm-9">
				<ul>
					<li class="home-nav-item"><h6>
							<a class="header-nav-anchor" href="redirectListaClientes.do">Lista de Clientes</a>
						</h6></li>
					<li><h6>
							<a class="header-nav-anchor"
								href="redirectListaUsuarios.do">Lista de Usuarios</a>
						</h6></li>
					<li class="transfer-nav-item"><h6>
							<a class="header-nav-anchor"
								href="redirectListaCuentas.do">Lista de Cuentas</a>
						</h6></li>
						<li class="nav-user-item">
							<h6 class="header-user-name">${Usuario}</h6>
								<i class="fa fa-user-circle header-user-icon" aria-hidden="true"></i>
						</li>
				</ul>
			</div>
		</div>
	</div>
	</header>