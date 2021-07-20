<%@ include file="HeaderMenu.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="title-container col-sm-12" id="titulo">
				<h1 class="title">Transacciones</h1>
			</div>
		</div>
		<div class="row tranference-content-row">
			<div class="col-sm-6">
				<img src="Assets/img/transaccion.jpg" class="">
			</div>
			<div class="col-sm-6">
				<h3 class="right-column-title">Enviar Tranferencia</h3>
				<form method="post" action="transferClient.do"
					class="form-content-container">
					<div class="row">
						<div class="col-sm-6 right-column-content">
							<label for="txtCBUOrigen" class="label-cbu">Seleccione
								Cuenta Origen</label>
						</div>
						<div class="col-sm-6 right-column-content">
							<select id="ddlCBUOrigen" name="ddlCBUOrigen" class="selecter-account">
								<c:forEach items="${cuentas}" var="cuenta">
									<option id="txtCBU" value="${cuenta.getCBU()}">${cuenta.getCBU()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-6 right-column-content">
							<label for="txtCBU" class="label-cbu">Ingrese el CBU</label>
						</div>
						<div class="col-sm-6 right-column-content">
							<input class="form-input transfer-input" id="txtCBU"
								name="txtCBU" type="number" min="10000" max="2147483647"/>
						</div>
						<div class="col-sm-6 right-column-content">
							<label for="txtMonto" class="label-cbu">Ingrese el Monto</label>
						</div>
						<div class="col-sm-6 right-column-content">
							<input class="form-input transfer-input" id="txtMonto"
								name="txtMonto" type="number" min="1" max="2147483647"/>
						</div>
						<div class="col-sm-6 right-column-content">
							<label for="txtMonto" class="label-cbu">Ingrese una
								descripción</label>
						</div>
						<div class="col-sm-6 right-column-content">
							<textarea class="form-input transfer-input" id="txtDescription"
								name="txtDescription"></textarea>
						</div>
					</div>
					<div class="col-sm-12 text-center">
						<input class="form-input paid-button" id="paid-button"
							name="paid-button" type="submit" />
					</div>
				</form>
				${Msg}
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>