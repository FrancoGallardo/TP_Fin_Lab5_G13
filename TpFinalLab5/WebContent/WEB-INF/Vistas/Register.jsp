
<%@ include file="HeaderLogin.jsp"%>
	<div class="container">
		<div class="row">
		<div class="col-md-12 text-center column-container">
			<div class="title-container ">
		<i class="fa fa-user-circle" aria-hidden="true"></i>
			</div>
			<div class="form-container">
				<form action="register.do" method="post">
									<div id="divPadre">
						<div class="user-container">
							<label class="form-label" for="txtUsuario">Nombre de Usuario :</label>
					<input
								id="txtUsuario" class="form-input user-input" name="txtUsuario" type="text"
								placeholder="Usuario" />
						</div>
						<div class="password-container">
							<label class="form-label" for="txtContrasenia">Contraseña
								:</label> <input class="form-input" id="txtContrasenia"
								name="txtContrasenia" type="password" placeholder="Contraseña" />
						</div>
							<div class="repeit-password-container">
							<label class="form-label" for="txtRepitPassword">Repetir Contraseña
								:</label> <input class="form-input" id="txtRepitPassword"
								name="txtRepitPassword" type="password" placeholder="Repetir Contraseña" />
						</div>
						<input class="login-button" id="btnAceptar" type="submit"
							value="Registrarse" /> 
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
						<a href="redirectLogin.do">Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
<%@ include file="FooterLogin.jsp"%>