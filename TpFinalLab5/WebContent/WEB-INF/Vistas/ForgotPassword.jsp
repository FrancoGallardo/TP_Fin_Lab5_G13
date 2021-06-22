
<%@ include file="HeaderLogin.jsp"%>
<title>Iniciar sesi�n</title>
</head>
<body class="login-container">
	<div class="container">
		<div class="row">
		<div class="col-md-12 text-center column-container">
			<div class="title-container ">
		<i class="fa fa-user-circle" aria-hidden="true"></i>
				<!-- <h1 class="header-title">Iniciar sesi�n:</h1> -->
			</div>
			<div class="form-container">
				<form action="forgotPassword.do" method="post">
					<div id="divPadre">
						<div class="user-container">
							<label class="form-label" for="txtUsuario">Usuario :</label>
					<input
								id="txtUsuario" class="form-input user-input" name="txtUsuario" type="text"
								placeholder="Usuario" />
						</div>
						<div class="password-container">
							<label class="form-label" for="txtContrasenia">Nueva Contrase�a
								:</label> <input class="form-input" id="txtContrasenia"
								name="txtContrasenia" type="password" placeholder="Contrase�a" />
						</div>
						<div class="password-container">
							<label class="form-label" for="txtRepitContrasenia">Repetir Contrase�a
								:</label> <input class="form-input" id="txtRepitContrasenia"
								name="txtRepitContrasenia" type="password" placeholder="Repetir Contrase�a" />
						</div>
						<input class="login-button" id="btnAceptar" type="button"
							value="Aceptar" /> ${Msg}
					</div>
				</form>
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