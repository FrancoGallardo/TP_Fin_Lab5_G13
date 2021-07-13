<%@ include file="HeaderAdmin.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container" id="titulo">
					<h1 class="title">Alta de Clientes</h1>
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
								<td><a id="addAccount" href="#" class="addAccount" onclick="agregar('bankTable',${ListadoClientes.indexOf(cli)},event)">Agregar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				${Msg}
				<div class="account-form">
					<form action="registerAccount.do" method="post">
						<label>CBU</label>
						<input id="txtCBU" class="" name="txtCBU" type="text"
								placeholder="CBU" />
						<label>Fecha de Creación</label>
						<input id="txtFechaCreacion" class="" name="txtFechaCreacion" type="date"
								placeholder="Fecha de creación" />
						<label>Tipo de Cuenta</label>
						<select id="ddlTipoCuenta" name="ddlTipoCuenta">
						<c:forEach items="${lstTipoCuenta}" var="TipoCuenta">
						 <option value="${TipoCuenta.getCodTipoCuenta()}">${TipoCuenta.getTipoCuenta()}</option>
						</c:forEach>
						</select>
						<label>Saldo</label>
						<input id="txtSaldo" class="" name="txtSaldo" type="number"
								placeholder="Saldo" />
						<input type="hidden" id="txtUsuario">
						<input type="submit" value="Agregar"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterAdmin.jsp"%>