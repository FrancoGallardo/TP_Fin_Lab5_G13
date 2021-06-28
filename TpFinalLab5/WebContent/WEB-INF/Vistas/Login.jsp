
<%@ include file="HeaderLogin.jsp"%>
	<div class="container">
		<div class="row">
		<div class="col-md-12 text-center column-container">
			<div class="title-container ">
		<i class="fa fa-user-circle" aria-hidden="true"></i>
				<!-- <h1 class="header-title">Iniciar sesión:</h1> -->
			</div>
			<div class="form-container">
				<form action="login.do" method="post">
					<div id="divPadre">
						<div class="user-container">
							<label class="form-label" for="txtUsuario">Usuario :</label>
					<input
								id="txtUsuario" class="form-input user-input" name="txtUsuario" type="text"
								placeholder="Usuario" />
						</div>
						<div class="password-container">
							<label class="form-label" for="txtContrasenia">Contraseña
								:</label> <input class="form-input" id="txtContrasenia"
								name="txtContrasenia" type="password" placeholder="Contraseña" />
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
						<a href="redirectForgotPassword.do">Cambiar Contraseña</a>
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