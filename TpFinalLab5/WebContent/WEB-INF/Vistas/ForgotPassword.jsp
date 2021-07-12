
<%@ include file="HeaderLogin.jsp"%>
	<div class="container">
		<div class="row">
		<div class="col-md-12 text-center column-container">
			<div class="title-container ">
		<i class="fa fa-user-circle" aria-hidden="true"></i>
			</div>
			<div class="form-container">
				<form action="forgotPassword.do" method="post">
					<div id="divPadre">
						<div class="user-container">
					<input
								id="txtUsuario" class="form-input user-input" name="txtUsuario" type="text"
								placeholder="Usuario" />
						</div>
						<div class="password-container"> 
						<input class="form-input" id="txtContrasenia"
								name="txtContrasenia" type="password" placeholder="Nueva Contraseña" />
						</div>
						<div class="password-container">
							 <input class="form-input" id="txtRepitContrasenia"
								name="txtRepitContrasenia" type="password" placeholder="Repetir Contraseña" />
						</div>
						<input class="login-button" id="btnAceptar" type="submit"
							value="Aceptar" />
					</div>
				</form>
				 ${Msg}
			</div>
			<div class="options-container">
				<div class=" buttons-container">
					<div class=" button-container">
						<a href="redirectLogin.do">Login</a>
					</div>
					<div class="button-container">
						<a href="redirectRegister.do">Registrarse</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="FooterLogin.jsp"%>