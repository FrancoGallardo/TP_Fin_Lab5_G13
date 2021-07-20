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
				<div class="form-content col-md-4">
				<label for="txtCBUOrigen" class="label-cbu">Seleccione Cuenta Origen</label>
					<select id="ddlCBUOrigen" class="label-cbu">
						<option id="txtCBU" value="0" >Seleccione</option>
					</select> 
				</div>
			<div class="form-content col-md-4">
					<label for="txtMonto" class="label-cbu">Ingrese el Monto</label> <input
						class="form-input" id="txtMonto" name="txtMonto" type="number" />
				</div>
				<div class="form-content col-md-4">
					<label for="txtCBUDestino" class="label-cbu">Seleccione Cuenta Destino</label> 					
					<select id="ddlCBUDestino" class="label-cbu">
						<option id="txtCBU" value="0" >Seleccione</option>
					</select> 
				</div>
				<div>
					<input class="form-input paid-button" id="paid-button"
						name="paid-button" type="submit" />
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>