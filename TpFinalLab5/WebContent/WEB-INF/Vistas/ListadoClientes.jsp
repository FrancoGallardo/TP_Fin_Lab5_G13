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
	                        <th>Estado</th>
	                        <th></th>
	                        <th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ListadoClientes}" var="cli">
						<tr>
							<td>${cli.getDNI()}</td>
							<td>${cli.getUsuario().getUsername()}</td>
							<td>${cli.getNombre()}</td>
							<td>${cli.getApellido()}</td>
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
								<c:choose>
						 	<c:when test = "${cli.getEstado() == 0}">
							<td><a href="modifyState.do?DNI=${cli.getDNI()}">Activar</a></td>
							</c:when>  
							<c:when test="${cli.getEstado() == 1}">
							<td><a href="modifyState.do?DNI=${cli.getDNI()}">Desactivar</a></td>
							</c:when>  
							</c:choose>
							<td><a href="redirectDetails.do?DNI=${cli.getDNI()}">Detalle</a></td>
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