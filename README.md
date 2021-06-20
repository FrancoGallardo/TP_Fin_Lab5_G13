# TP_Fin_Lab5_G13

Trabajo Practico Final de laboratorio 5 del Grupo 13

administrador (usuario: admin contraseña: admin)

Pantallas Principales: 
- Pantalla de log in donde el usuario se podra loguear , registrar , cambiar contraseña (revisar);
- Administrador  listado de clientes 
- Administrador listado de cuentas
- Usuario operaciones por cuenta 
- Usuario trnasferencia a otros clientes
- Usuario, transferencia a cuentas propias

Pantallas Secundarias:
- Administrador:  historial de transacciones
- Pantalla Principal 

Base de datos: 

-Usuario:
	int idUsuario;
	string email
	string contrasena
	string nombre de usuario 
	int estado
	
-Cliente
	int idCliente;
	int idUsuario;
	int dni
	string nombre
	string apellido
	string sexo
	string nacionalidad
	int telefono
	string direccion
	string localidad
	strinf provincia
	date fecha de nacimiento
	int estado

-Cuenta:
	int CBU
	int Nrcuenta
	double monto
	int idTipoCuenta
	int estado
	
-Tipo de cuenta
	int idTipoCuenta
	string descripcion
	

-Transacciones:
	int idTransacciones
	int CBU egreso
	int CBU ingresa
	double monto
	string descripcion
	date fecha

	
