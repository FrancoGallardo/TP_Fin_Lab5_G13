<%@ include file="HeaderMenu.jsp"%>
<script>
	$(document).ready(function() {
		$('#tablaClientes').DataTable({
			"lengthChange" : false,
			"info" : false,
			"pageLength" : 5
		});
	});
</script>
<title>Alta Cliente</title>
</head>
<body>
	<div class="container content-container">
		<div class="title-container" id="titulo">
			<h1 class="title">Alta de Clientes</h1>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table id="tablaClientes">
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
						</tr>
							<tr>
							<td>2</td>
							<td>455484512</td>
							<td>121524510</td>
							<td>121545</td>
							<td>Pesos</td>
							<td>4500</td>
							<td>21/06/2021</td>
							<td>Pendiente</td>
						</tr>
					</tbody>
				</table>
				${Msg}
			</div>
		</div>
	</div>
	<%@ include file="FooterMenu.jsp"%>