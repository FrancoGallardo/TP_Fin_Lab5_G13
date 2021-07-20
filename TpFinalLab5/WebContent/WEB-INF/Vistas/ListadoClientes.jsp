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
						<form method="post" action="modifyState.do?DNI=${cli.getDNI()}">
							<td>${cli.getDNI()}</td>
							<td>${cli.getUsuario().getUsername()}</td>
							<td>${cli.getNombre()}</td>
							<td>${cli.getApellido()}</td>
							<td>
							<select id="ddlState" name="ddlState">
							<c:choose>
							<c:when test = "${cli.getEstado() == 2}">
							<option value="2" selected="selected">Pendiente</option>
							</c:when> 
							<c:otherwise>
							<option value="2">Pendiente</option>
							 </c:otherwise>
							 	</c:choose>
							 			<c:choose>
							<c:when test = "${cli.getEstado() == 1}">
							<option value="1" selected="selected">Activar</option>
									</c:when> 
											<c:otherwise>
											<option value="1">Activar</option>
							 </c:otherwise>
							 	</c:choose>
							 			<c:choose>
								<c:when test = "${cli.getEstado() == 0}">
							<option value="0" selected="selected">Denegado</option>
									</c:when> 
									<c:otherwise>
										<option value="0">Denegado</option>
									 </c:otherwise>
									 		 	</c:choose>
							</select>
								</td>
									<td><a href="redirectDetails.do?DNI=${cli.getDNI()}">Detalle</a></td>
								<td>
								<input name="btnModificar" type="submit" class="changeState" value="Cambiar Estado">
								</td>
							</form>
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