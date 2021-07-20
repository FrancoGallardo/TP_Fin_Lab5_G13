<%@ include file="HeaderMenu.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="title-container col-sm-12" id="titulo">
				<h1 class="title">Operaciones</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<form action="changeAccount.do" method="post">
					<div class="row opertation-row">
						<div class="col-sm-6">
							<label style="display: block">Cuenta</label>
						</div>
						<div class="col-sm-6">
							<select id="ddlCBUOrigen" name="ddlCBUOrigen" class="selecter-account"
								style="display: block">
								<c:forEach items="${cuentas}" var="cuenta">
									<option id="txtCBU" value="${cuenta.getCBU()}">${cuenta.getCBU()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<input type="submit" value="Cambiar cuenta" style="display: block; margin: 0 auto;">
				</form>
			</div>
		</div>
		<div class="row opertation-row">
			<div class="col-sm-12">
				<table id="bankTable">
					<thead>
						<tr>
							<th>Numero Transacción</th>
							<th>CBU emisor</th>
							<th>CBU receptor</th>
							<th>Descripcion</th>
							<th>Monto</th>
							<th>Fecha de la operación</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${transacciones}" var="transaccion">
							<tr>
								<td>${transaccion.getIdTransaccion()}</td>
								<td>${transaccion.getCBU_Egreso()}</td>
								<td>${transaccion.getCBU_Ingresa()}</td>
								<td>${transaccion.getDescripcion()}</td>
								<td>${transaccion.getMonto()}</td>
								<td>${transaccion.getFecha()}</td>
								<td>${transaccion.getEstado()}</td>
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