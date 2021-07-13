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
		<div class="row">
			<div class="col-sm-12">
				<div class="client-data-container">
					<form action="addClient.do?User=${sessionScope.Username}" method="post">
						<label>Numero de Documento:</label> 
						<input type="number"
							id="txtDocumento" name="txtDocumento" style="margin-right: 1%"
							placeholder="Documento" /> 
						<label>Nombre:</label> 
						<input type="text" id="txtNombre"
							name="txtNombre" style="margin-right: 1%" placeholder="Nombre" />
						<label>Apellido:</label> 	
						<input type="text" id="txtApellido" name="txtApellido"
							style="margin-right: 1%" placeholder="Apellido" />
						<label>Sexo:</label> 
						<select id="ddlSexo" name="ddlSexo"
							style="margin-right: 1%; width: 6%; text-align: center">
							<option value="Hombre">Masculino</option>
							<option value="Mujer">Femenino</option>
						</select> 
						<label>Fecha de nacimiento:</label> 
						 <input type="date" id="dtFechaNac"
							name="dtFechaNac" min="1900-01-01">
						 <label>Nacionalidad:</label> 
						 <input type="text"
							id="txtNacionalidad" name="txtNacionalidad"
							style="margin-right: 1%" placeholder="Nacionalidad" />
						<label>Dirección:</label> 
						<input type="text" id="txtDireccion"
							name="txtDireccion" style="margin-right: 1%"
							placeholder="Dirección" />
							<label>Localidad:</label> 
						<select id="ddlLocalidad"
							name="ddlLocalidad" placeholder="Localidad">
							<option value="-1">Seleccione...</option>
							<c:forEach items="${lstLoc}" var="loc">
								<option value="${loc.getIdLocalidad()},${loc.getDescripcion()}">${loc.getDescripcion()}</option>
							</c:forEach>
						</select> 
						<label>Provincia:</label> 
						<select id="ddlProvincia" name="ddlProvincia"
							onchange="sacarHidden(this.value,0, -1)" placeholder="Provincia">
							<option value="-1">Seleccione...</option>
							<c:forEach items="${lstProv}" var="prov">
								<option value="${prov.getIdProvincia()},${prov.getDescripcion()}">${prov.getDescripcion()}</option>
							</c:forEach>
						</select> 
						<input
							class="botoncargar" id="txtAgregar" name="txtAceptar"
							type="submit" value="Agregar" /> 
					</form>
					${Msg}
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>