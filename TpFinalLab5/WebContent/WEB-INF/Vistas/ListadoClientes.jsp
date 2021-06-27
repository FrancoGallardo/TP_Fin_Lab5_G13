<%@ include file="HeaderAdmin.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container" id="titulo">
					<h1 class="title">Listado de Clientes</h1>
				</div>
				<table id="bankTable">
					<thead>
						<tr>
							<th>DNI</th>
	                        <th>Usuario</th>
	                        <th>Nombre</th>
	                        <th>Apellido</th>
	                        <th>Sexo</th>
	                        <th>Nacionalidad</th>
	                        <th>Fecha de Nacimiento</th>
	                       	<th>Direccion</th>
	                        <th>Localidad</th>
	                        <th>Provincia</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ListadoClientes}" var="cli">
						<tr>
							<td>${cli.getDNI()}</td>
							<td>${cli.getUsuario().getUsername()}</td>
							<td>${cli.getNombre()}</td>
							<td>${cli.getApellido()}</td>
							<td>${cli.getSexo()}</td>
							<td>${cli.getNacionalidad()}</td>
							<td>${cli.getFecha()}</td>
							<td>${cli.getDireccion()}</td>
							<td>${cli.getLocalidad()}</td>
							<td>${cli.getProvincia()}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				${Msg}
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>