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
	                        <th>Estado</th>
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
							<td>${cli.getLocalidad().getDescripcion()}</td>
							<td>${cli.getProvincia().getDescripcion()}</td>
							<c:choose>
						 	<c:when test = "${cli.getEstado() == 0}">
							<td>Denegado</td>
							</c:when>  
							<c:when test="${cli.getEstado() == 1}">
							<td>Activo</td>
							</c:when>  
							<c:when test="${cli.getEstado() == 2}">
							<td>Pendiente</td>
							</c:when>  
						</c:choose>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				${Msg}
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterAdmin.jsp"%>