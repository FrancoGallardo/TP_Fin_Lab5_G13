<%@ include file="HeaderAdmin.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container col-sm-12" id="titulo">
					<h1 class="title">Lista de Cuentas</h1>
				</div>
				<table id="bankTable">
					<thead>
						<tr>
							<th>CBU</th>
							<th>Nombre de la Cuenta</th>
							<th>Fecha de la operación</th>
							<th>Tipo de Cuenta</th>							
							<th>Saldo</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${lstCuentas}" var="cuenta">
						<tr>
							<td>${cuenta.getCBU()}</td>
							<td>${cuenta.getNumeroCuenta()}</td>
							<td>${cuenta.getFecha_Creacion()}</td>
							<td>${cuenta.getCodTipoCuenta()}</td>
							<td>${cuenta.getSaldo()}</td>
							<td>${cuenta.getEstado()}</td>
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