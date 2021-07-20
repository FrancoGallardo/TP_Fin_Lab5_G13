<%@ include file="HeaderMenu.jsp"%>
<div class="main-container">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container">
					<h1>Registrar Cliente</h1>
				</div>
			</div>
		</div>
		<div class="row client-content">
			<div class="col-sm-12">
				<div class="client-data-container">
					<form action="addClient.do?User=${sessionScope.name}"
						method="post">
						<div class="row">
							<div class="col-sm-6">
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Numero de
											Documento:</label>
									</div>
									<div class="col-sm-6">
										<input type="number" id="txtDocumento" name="txtDocumento"
											placeholder="Documento" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Nombre:</label>
									</div>
									<div class="col-sm-6">
										<input type="text" id="txtNombre" name="txtNombre"
											placeholder="Nombre" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Apellido:</label>
									</div>
									<div class="col-sm-6">
										<input type="text" id="txtApellido" name="txtApellido"
											placeholder="Apellido" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Sexo:</label>
									</div>
									<div class="col-sm-6">
										<select id="ddlSexo" name="ddlSexo">
											<option value="Hombre">Masculino</option>
											<option value="Mujer">Femenino</option>
										</select>
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Fecha de
											nacimiento:</label>
									</div>
									<div class="col-sm-6">
										<input type="date" id="dtFechaNac" name="dtFechaNac" value="${fecha}"
											min="1900-01-01">
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Nacionalidad:</label>
									</div>
									<div class="col-sm-6">
										<input type="text" id="txtNacionalidad" name="txtNacionalidad"
											placeholder="Nacionalidad" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Dirección:</label>
									</div>
									<div class="col-sm-6">
										<input type="text" id="txtDireccion" name="txtDireccion"
											placeholder="Dirección" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Localidad:</label>
									</div>
									<div class="col-sm-6">
										<select id="ddlLocalidad"
							name="ddlLocalidad" placeholder="Localidad">
							<option value="-1">Seleccione...</option>
							<c:forEach items="${lstLoc}" var="loc">
								<option value="${loc.getIdLocalidad()},${loc.getDescripcion()}">${loc.getDescripcion()}</option>
							</c:forEach>
						</select> 
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label class="create-client-label">Provincia:</label>
									</div>
									<div class="col-sm-6">
										<select id="ddlProvincia" name="ddlProvincia"
							onchange="sacarHidden(this.value,0, -1)" placeholder="Provincia">
							<option value="-1">Seleccione...</option>
							<c:forEach items="${lstProv}" var="prov">
								<option value="${prov.getIdProvincia()},${prov.getDescripcion()}">${prov.getDescripcion()}</option>
							</c:forEach>
						</select> 
									</div>
								</div>
							</div>
						</div>
						<input class="botoncargar" id="txtAgregar" name="txtAceptar"
							type="submit" value="Agregar" />
					</form>
					${Msg}
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>