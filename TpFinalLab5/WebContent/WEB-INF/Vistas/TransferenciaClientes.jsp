<%@ include file="HeaderMenu.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="title-container col-sm-12" id="titulo">
				<h1 class="title">Transacciones</h1>
			</div>
		</div>
		<div class="row">
			<form method="get" action=""
				class="form-content-container text-center">
				<div class="form-content col-md-6">
					<label for="txtCBU" class="label-cbu">Ingrese el CBU</label> <input
						class="form-input" id="txtCBU" name="txtCBU" type="number" />
				</div>
				<div class="form-content col-md-6">
					<label for="txtMonto" class="label-cbu">Ingrese el Monto</label> <input
						class="form-input" id="txtMonto" name="txtMonto" type="number" />
				</div>
				<input class="form-input paid-button" id="paid-button"
					name="paid-button" type="submit" />
			</form>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table id="bankTable">
					<thead>
						<tr>
							<th>Numero Transacción</th>
							<th>CBU emisor</th>
							<th>CBU receptor</th>
							<th>Nombre de la Cuenta</th>
							<th>Tipo de Cuenta</th>
							<th>Monto</th>
							<th>Fecha de la operación</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>455484512</td>
							<td>121524510</td>
							<td>121545</td>
							<td>Pesos</td>
							<td>2500</td>
							<td>21/06/2021</td>
							<td>Realizado</td>
					</tbody>
				</table>
				${Msg}
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>