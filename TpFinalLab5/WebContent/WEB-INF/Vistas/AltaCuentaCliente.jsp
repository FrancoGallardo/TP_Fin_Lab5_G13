<%@ include file="HeaderAdmin.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container" id="titulo">
					<h1 class="title">Alta de Cuenta</h1>
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
							<th>Agregar</th>
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
								<td><a id="addAccount" href="#" class="addAccount"
									onclick="agregar('bankTable',${ListadoClientes.indexOf(cli)},event)">Agregar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				${Msg}
				<div class="account-form">
					<form action="registerAccount.do" method="post">
						<div class="row">
							<div class="col-sm-6">
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label>CBU</label>
									</div>
									<div class="col-sm-6">
										<input id="txtCBU" class="" name="txtCBU" type="number" min="1000" max="2147483647"
											placeholder="CBU" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label>Fecha de Creación</label>
									</div>
									<div class="col-sm-6">
										<input id="txtFechaCreacion" class="" name="txtFechaCreacion"
											type="date" value="${fecha}" placeholder="Fecha de creación" />
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label>Tipo de Cuenta</label>
									</div>
									<div class="col-sm-6">
										<select id="ddlTipoCuenta" name="ddlTipoCuenta">
											<c:forEach items="${lstTipoCuenta}" var="TipoCuenta">
												<option value="${TipoCuenta.getCodTipoCuenta()}">${TipoCuenta.getTipoCuenta()}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="row create-client-row">
									<div class="col-sm-6">
										<label>Saldo</label>
									</div>
									<div class="col-sm-6">
										<input id="txtSaldo" class="" name="txtSaldo" type="number"
											placeholder="Saldo" value="10000" ReadOnly/>
									</div>
								</div>
							</div>
						</div>
						<input type="hidden" id="txtUsuario" name="txtUsuario"> <input type="submit"
							value="Agregar" />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterAdmin.jsp"%>