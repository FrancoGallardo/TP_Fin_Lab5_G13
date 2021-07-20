<%@page import="entidad.Cliente"%>
<%@ include file="HeaderAdmin.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container" id="titulo">
					<h1 class="title" style="padding: 30px 0;">Datos Cliente</h1>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="row details-row">
							<div class="col-sm-6">
								<span>DNI</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getDNI()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Usuario</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getUsuario().getUsername()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Nombre</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getNombre()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Apellido</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getApellido()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Sexo</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getSexo()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Nacionalidad</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getNacionalidad()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Direccion</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getDireccion()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Localidad</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getLocalidad().getDescripcion()}</span>
							</div>
						</div>
						<div class="row details-row">
							<div class="col-sm-6">
								<span>Provincia</span>
							</div>
							<div class="col-sm-6">
								<span>${cliente.getProvincia().getDescripcion()}</span>
							</div>
						</div>
					</div>
				</div>
				${Msg}
					</div>
			</div>
			<div class="row" style="margin-top: 20px">
			<div class="col-sm-12">
			<a class="return-anchor" href="redirectListaClientes.do">Regresar</a>
			</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterAdmin.jsp"%>