<%@ include file="HeaderMenu.jsp"%>
	<div class="main-container">
		<div class="container content-container">
			<div class="title-container" id="titulo">
				<h1 class="title">Transacciones</h1>
			</div>
			<div class="row">
				<div class="col-sm-3">
				<div>
				<h4>Seleccione el Tipo de cuenta</h4>
				</div>
				<div>
				<select>
					<option>Cuenta en Pesos</option>
					<option>Cuenta en Dolares</option>
				</select>
				</div>
				</div>
				<div class="col-sm-9">
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