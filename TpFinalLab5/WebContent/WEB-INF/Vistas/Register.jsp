
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
							<i class="fa fa-user-circle-o user-icon" aria-hidden="true"></i>
							<input id="txtUsuario" class="form-input user-input" name="txtUsuario" type="text" placeholder="Usuario" />
						</div>
						
						<div class="password-container">
							<i class="fa fa-lock pass-icon" aria-hidden="true"></i>
							<input class="form-input" id="txtContrasenia" name="txtContrasenia" type="password" placeholder="Contraseņa" />
						</div>
						
						<div class="repeit-password-container">
							<i class="fa fa-lock repitPass-icon" aria-hidden="true"></i>
							<input class="form-input" id="txtRepitPassword" name="txtRepitPassword" type="password" placeholder="Repetir Contraseņa" />
						
						</div>
							<input class="login-button" id="btnAceptar" type="submit" value="Registrarse" /> 
						</div>
						
				</form>
				${Msg}
			</div>
			<div class="options-container">
				<div class=" buttons-container">
					<div class=" button-container">
						<a href="redirectForgotPassword.do">Cambiar Contraseņa</a>
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