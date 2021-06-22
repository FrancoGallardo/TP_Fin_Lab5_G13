<%@ include file="HeaderMenu.jsp"%>
<script>
	$(document).ready(function() {
		$('#tablaTransacciones').DataTable({
			"lengthChange" : false,
			"info" : false,
			"pageLength" : 5
		});
	});
</script>
<title>Operaciones</title>
</head>
<header class="header-container">
	<div class="container">
		<div class="row">
			<div class="cool-sm-12">
				<ul>
					<li><h5>
							<a class="header-nav-anchor" href="redirectMenuPrincipal.do">Menu
								Principal</a>
						</h5></li>
					<li><h5>
							<a class="header-nav-anchor"
								href="redirectTransferenciaCliente.do">Transferencias a
								clientes</a>
						</h5></li>
					<li><h5>
							<a class="header-nav-anchor"
								href="redirectTransferenciaPropias.do">Transferencias a
								cuentas propias</a>
						</h5></li>
					<li><h5>
							<a class="header-nav-anchor" href="redirectOperacionesCuenta.do">Operaciones
								por cuenta</a>
						</h5></li>
				</ul>
			</div>
		</div>
	</div>
</header>
<body>
	<div class="main-container">
		<div class="container content-container">
			<div class="title-container" id="titulo">
				<h1 class="title">Transacciones</h1>
			</div>
			<div class="row">
				<div class="col-sm-12">
				<form method="get" action="" class="form-content-container text-center">
						<div class="">
							<label for="txtCBU" class="label-cbu">Ingrese el CBU</label> <input
								class="form-input" id="txtCBU" name="txtCBU" type="number" />
						</div>
						<input class="form-input" id="search-client" name="search-client"
							type="submit" />
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<table id="tablaTransacciones">
						<thead>
							<tr>
								<th>Numero Transacción</th>
								<th>CBU emisor</th>
								<th>CBU receptor</th>
								<th>Nombre de la Cuenta</th>
								<th>Tipo de Cuenta</th>
								<th>Monto</th>
								<th>Fecha de la operación</th>
								<th>Estado</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>455484512</td>
								<td>121524510</td>
								<td>121545</td>
								<td>Pesos</td>
								<td>2500</td>
								<td>21/06/2021</td>
								<td>Realizado</td>
						</tbody>
					</table>
					${Msg}
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<form method="get" action="" class="form-content-container text-center">
						<div class="">
							<label for="txtMonto" class="label-cbu">Ingrese el Monto</label>
							<input class="form-input" id="txtMonto" name="txtMonto"
								type="number" />
						</div>
						<input class="form-input" id="paid-button" name="paid-button"
							type="submit" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="FooterMenu.jsp"%>