package controller;

import javax.jws.WebParam.Mode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import negocioImp.ClienteNImp;
import negocioImp.CuentaNImp;
import negocioImp.LocalidadNImp;
import negocioImp.ProvinciaNImp;
import negocioImp.TipoCuentaNImp;
import negocioImp.UsuarioNImp;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Localidad;
import entidad.Provincia;
import entidad.TipoCuenta;
import entidad.Usuario;

@Controller
@SessionAttributes("Username")
public class LoginController {
	UsuarioNImp nUser = new UsuarioNImp();
	ClienteNImp nCli = new ClienteNImp();
	LocalidadNImp nLoc = new LocalidadNImp();
	ProvinciaNImp nProv = new ProvinciaNImp();
	CuentaNImp nCuenta = new CuentaNImp();
	TipoCuentaNImp nTipoCuenta = new TipoCuentaNImp();

	Usuario user = new Usuario();
	Cliente cli = new Cliente();
	Localidad loc = new Localidad();
	Provincia prov = new Provincia();
	Cuenta cuenta = new Cuenta();
	TipoCuenta tCuenta = new TipoCuenta();

	public void insertarLocalidades() {
		prov.setIdProvincia(1);
		prov.setDescripcion("Buenos Aires");

		loc.setDescripcion("San Fernando");
		loc.setProvincia(prov);
		nLoc.insertarLocalidad(loc);
		loc.setDescripcion("Tigre");
		loc.setProvincia(prov);
		nLoc.insertarLocalidad(loc);
	}

	public void insertarProvincias() {
		prov.setDescripcion("Buenos Aires");
		nProv.insertarProvincia(prov);
		prov.setDescripcion("Salta");
		nProv.insertarProvincia(prov);
		prov.setDescripcion("Cordoba");
		nProv.insertarProvincia(prov);
		prov.setDescripcion("Entre R�os");
		nProv.insertarProvincia(prov);
	}

	public void insertarTipoCuenta() {
		tCuenta.setTipoCuenta("Pesos");
		nTipoCuenta.insertarTipoCuenta(tCuenta);
		tCuenta.setTipoCuenta("Dolares");
		nTipoCuenta.insertarTipoCuenta(tCuenta);
	}

	// redireccionar al menu principal por el login
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView eventoRedirectMenu(String txtUsuario, String txtContrasenia) {
		int x = UserExist(txtUsuario,  txtContrasenia);
		System.out.println(x);
		ModelAndView mv = new ModelAndView();
		if (x==1)
		{
			List<Cliente> lstCliente = nCli.obtenerClientes();
			mv.setViewName("ListadoClientes");
			mv.addObject("ListadoClientes", lstCliente);
			mv.addObject("PageTitle", "Listado Clientes");
			mv.addObject("Username", user.getUsername());
		} 
		else if(x==2)
		{
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
			mv.addObject("Username", user.getUsername());
		}
		else if(x==0) 
		{
			mv.setViewName("Login");
			mv.addObject("PageTitle", "Login");
			mv.addObject("Msg", "Error, los datos ingresados no son correctos.");
		}

		
		return mv;
	}

	public int UserExist(String txtUsuario, String txtContrasenia) 
	{
		try 
		{
			user = nUser.verificarUsuario(txtUsuario);	
			if(user != null && user.getPassword().equals(txtContrasenia)) 
			{
				if(user.getTipoUsuario().equals("administrador")) 
				{
					//Devuelve 1 si existe el usuario y es admin
					return 1;
				}
				else 
				{
					//Devuelve 2 si existe el usuario y no es admin
					return 2;
				}

			}
			else 
			{
				//Devuelve 0 Si no existe esa combinacion o el usuario
				return 0;
			}

		}
		catch(Exception ex) 
		{
			return -1; 
		}
	}
	
	
	
	public boolean verificarCliente(String User, String txtDocumento, String txtNombre, String txtApellido,
			String ddlSexo, String txtNacionalidad, String ddlProvincia, String ddlLocalidad, String txtDireccion,
			String dtFechaNac) {
		boolean verificar = false;
		if (!(txtDocumento.trim().isEmpty() || txtNombre.trim().isEmpty() || txtApellido.trim().isEmpty()
				|| ddlSexo.trim().isEmpty() || User == null || txtNacionalidad.trim().isEmpty() || ddlProvincia == null
				|| ddlProvincia.trim().isEmpty() || ddlLocalidad == null || ddlLocalidad.trim().isEmpty()
				|| txtDireccion.trim().isEmpty() || dtFechaNac.trim().isEmpty())) {
			if (Integer.parseInt(txtDocumento) >= 0) {
				if (nCli.buscarCliente(Integer.parseInt(txtDocumento)) == null) {
					user.setUsername(User);
					Date FechaNac = null;
					Provincia prov = new Provincia();
					Localidad loc = new Localidad();
					String[] provincia = ddlProvincia.split(",");
					String[] localidad = ddlLocalidad.split(",");
					prov.setIdProvincia(Integer.parseInt(provincia[0]));
					prov.setDescripcion(provincia[1]);
					loc.setProvincia(prov);
					loc.setIdLocalidad(Integer.parseInt(localidad[0]));
					loc.setDescripcion(localidad[1]);
					try {
						FechaNac = new SimpleDateFormat("yyyy-mm-dd").parse(dtFechaNac);
						cli.setFecha(FechaNac);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cli.setDNI(Integer.parseInt(txtDocumento));
					cli.setNombre(txtNombre);
					cli.setApellido(txtApellido);
					cli.setSexo(ddlSexo);
					cli.setUsuario(user);
					cli.setNacionalidad(txtNacionalidad);
					cli.setLocalidad(loc);
					cli.setProvincia(prov);
					cli.setDireccion(txtDireccion);
					cli.setFecha(FechaNac);
					cli.setEstado(2);
					verificar = true;
				} else {
					verificar = false;
				}
			} else {
				verificar = false;
			}
		} else {
			verificar = false;
		}
		return verificar;
	}

	@RequestMapping("addClient.do")
	public ModelAndView eventoAddCliente(String User, String txtDocumento, String txtNombre, String txtApellido,
			String ddlSexo, String txtNacionalidad, String ddlProvincia, String ddlLocalidad, String txtDireccion,
			String dtFechaNac) {
		boolean usuarioVerificado = false;
		ModelAndView mv = new ModelAndView();
		usuarioVerificado = verificarCliente(User, txtDocumento, txtNombre, txtApellido, ddlSexo, txtNacionalidad,
				ddlProvincia, ddlLocalidad, txtDireccion, dtFechaNac);
		if (usuarioVerificado) {
			nCli.insertarCliente(cli);
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
			mv.addObject("Msg", "Cliente Registrado Correctamente");
		} else {
			List<Localidad> lstLoc = nLoc.obtenerLocalidades();
			List<Provincia> lstProv = nProv.obtenerProvincias();
			mv.addObject("lstLoc", lstLoc);
			mv.addObject("lstProv", lstProv);
			mv.setViewName("AltaCliente");
			mv.addObject("PageTitle", "Registrar Cliente");
			mv.addObject("Msg", "Error, los datos ingresados no son correctos.");
		}
		mv.addObject("Usuario", user.getUsername());
		return mv;
	}

	// redireccionar al menu principal tras registrarse
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public ModelAndView eventoRegister(String txtUsuario, String txtContrasenia, String txtRepitPassword) {
		ModelAndView mv = new ModelAndView();
		System.out.println("User: " + txtUsuario +"  pass: " + txtContrasenia + "  RPass: " + txtRepitPassword);
		if (txtContrasenia.equals(txtRepitPassword)) 
		{
			if (nUser.verificarUsuario(txtUsuario) == null) 
			{
				user.setPassword(txtContrasenia);
				user.setUsername(txtUsuario);
				user.setEstado(true);
				user.setTipoUsuario("Cliente");
				nUser.insertarUsuario(user);
				mv.setViewName("MenuPrincipal");
				mv.addObject("PageTitle", "Menu Principal");
				mv.addObject("Username", user.getUsername());
				mv.addObject("Msg", "Usuario registrado correctamente.");
			} 
			else 
			{
				mv.setViewName("Register");
				mv.addObject("PageTitle", "Registrarse");
				mv.addObject("Msg", "Error, el usuario ingresado ya se encuentra registrado.");
			}
		} 
		else 
		{
			mv.setViewName("Register");
			mv.addObject("PageTitle", "Registrarse");
			mv.addObject("Msg", "Error, las contraseñas ingresadas no son iguales.");
		}
		return mv;
	}

	// Cambiar contrasena redirecciona al login
	@RequestMapping("forgotPassword.do")
	public ModelAndView eventoForgotPassword(String txtUsuario, String txtContrasenia, String txtRepitContrasenia) {
		ModelAndView mv = new ModelAndView();
		if (txtContrasenia.equals(txtRepitContrasenia)) {
			user = nUser.verificarUsuario(txtUsuario);
			if (user != null) {
				user.setPassword(txtContrasenia);
				boolean modificar = false;
				modificar = nUser.modificar(user);
				if (modificar) {
					mv.setViewName("Login");
					mv.addObject("PageTitle", "Login");
					mv.addObject("Msg", "Contrase�a modificada correctamente");
				} else {
					mv.setViewName("ForgotPassword");
					mv.addObject("PageTitle", "Cambiar Contrase�a");
					mv.addObject("Msg", "Error, no se logro modificar la contrase�a.");
				}
			} else {
				mv.setViewName("ForgotPassword");
				mv.addObject("PageTitle", "Cambiar Contrase�a");
				mv.addObject("Msg", "Error, el usuario ingresado no se encuentra registrado.");
			}
		} else {
			mv.setViewName("ForgotPassword");
			mv.addObject("PageTitle", "Cambiar Contrase�a");
			mv.addObject("Msg", "Error, las contrase�as no son iguales.");
		}
		return mv;
	}

	public boolean verificarCuenta(String txtCBU, String txtFechaCreacion, String ddlTipoCuenta, String txtSaldo) {
		boolean verificar = false;
		if (Integer.parseInt(txtCBU) > 0) {
			if (!nCuenta.verificarCuenta(Integer.parseInt(txtCBU))) {
				cuenta.setCBU(Integer.parseInt(txtCBU));
				if (ddlTipoCuenta != "") {
					cuenta.setCodTipoCuenta(Integer.parseInt(ddlTipoCuenta));
					if (Double.parseDouble(txtSaldo) > 0) {
						cuenta.setSaldo(Double.parseDouble(txtSaldo));
						verificar = true;
						Date FechaNac = null;
						try {
							FechaNac = new SimpleDateFormat("yyyy-mm-dd").parse(txtFechaCreacion);
							cli.setFecha(FechaNac);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							verificar = false;
						}
						cuenta.setFecha_Creacion(FechaNac);
						cuenta.setEstado(true);
					} else {
						verificar = false;
					}
				} else {
					verificar = false;
				}
			} else {
				verificar = false;
			}
		} else {
			verificar = false;
		}
		return verificar;
	}

	@RequestMapping("registerAccount.do")
	public ModelAndView eventoRegistrarCuenta(String txtCBU, String txtFechaCreacion, String ddlTipoCuenta,
			String txtSaldo) {
		ModelAndView mv = new ModelAndView();
		boolean verificar = verificarCuenta(txtCBU, txtFechaCreacion, ddlTipoCuenta, txtSaldo);
		if (verificar) {
			nCuenta.insertarCuenta(cuenta);
			mv.addObject("Msg", "Cuenta registrada correctamente.");
		} else {
			mv.addObject("Msg", "Error, los datos ingresados no son correctos.");
		}
		List<Cliente> lstCliente = nCli.obtenerClientes();
		mv.addObject("ListadoClientes", lstCliente);
		mv.setViewName("AltaCuentaCliente");
		mv.addObject("PageTitle", "Alta Cuenta");
		return mv;
	}
	
	public void verificarEstadoCliente(String ddlState) {
		switch(cli.getEstado()) {
		case 0:
			cli.setEstado(1);
			break;
		case 1:
			cli.setEstado(0);
			break;
		case 2:
			cli.setEstado(1);
			break;
		}
	}
	
	
	@RequestMapping("modifyState.do")
	public ModelAndView eventoModificarEstado(String DNI , String ddlState) {
		ModelAndView mv = new ModelAndView();
		cli = nCli.buscarCliente(Integer.parseInt(DNI));
		System.out.println(ddlState);
		verificarEstadoCliente(ddlState);
		nCli.modificar(cli);
		mv.setViewName("ListadoClientes");
		List<Cliente> lstCliente = nCli.obtenerClientes();
		mv.addObject("ListadoClientes", lstCliente);
		mv.addObject("PageTitle", "Listado Clientes");
		return mv;
	}
	
	@RequestMapping("transferClient.do")
	public ModelAndView eventoTrasferClient(String txtCBU , String txtMonto) {
		ModelAndView mv = new ModelAndView();
		if(nCuenta.verificarCuenta(Integer.parseInt(txtCBU))) {
			
			mv.addObject("Msg", "Transferencia realizada exitosamente");
		} else {
			mv.addObject("Msg", "El cbu ingresado no pertenece a ninguna cuenta existente");
		}
		mv.setViewName("TransferenciaClientes");
		mv.addObject("PageTitle", "Transferencia a Clientes");
		return mv;
	}
	

	@RequestMapping("redirectDetails.do")
	public ModelAndView eventoRedireccionarDetalles(String DNI) {
		ModelAndView mv = new ModelAndView();
		cli = nCli.buscarCliente(Integer.parseInt(DNI));
		mv.setViewName("DatosCliente");
		mv.addObject("PageTitle", "Datos Cliente");
		mv.addObject("cliente", cli);
		return mv;
	}
	

	// redireccionar a login
	@RequestMapping("redirectLogin.do")
	public ModelAndView eventoInicarAplicaciones() {
		ModelAndView mv = new ModelAndView();
		// insertarProvincias();
		// insertarLocalidades();
		mv.setViewName("Login");
		mv.addObject("PageTitle", "Login");
		return mv;
	}

	// redireccionar a register
	@RequestMapping("redirectRegister.do")
	public ModelAndView eventoRedirectRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Register");
		mv.addObject("PageTitle", "Registrarse");
		return mv;
	}

	// redireccionar a forgot password
	@RequestMapping("redirectForgotPassword.do")
	public ModelAndView eventoRedirectForgotPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ForgotPassword");
		mv.addObject("PageTitle", "Cambiar Contrase�a");
		return mv;
	}

	// redireccionar a operaciones cuenta
	@RequestMapping("redirectOperacionesCuenta.do")
	public ModelAndView eventoRedirectOperecionesCuenta() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OperacionesCuenta");
		mv.addObject("PageTitle", "Operaciones Cuenta");
		return mv;
	}

	@RequestMapping("redirectMenuPrincipal.do")
	public ModelAndView eventoRedirectMenuPrincipal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MenuPrincipal");
		mv.addObject("PageTitle", "Menu Principal");
		return mv;
	}

	@RequestMapping("redirectTransferenciaCliente.do")
	public ModelAndView eventoRedirectTransferenciaClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("TransferenciaClientes");
		mv.addObject("PageTitle", "Transferencia a Clientes");
		return mv;
	}

	@RequestMapping("redirectTransferenciaPropias.do")
	public ModelAndView eventoRedirectTransferenciaPropias() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("TransferenciaPropias");
		mv.addObject("PageTitle", "Transferencias a Cuentas Propias");
		return mv;
	}

	@RequestMapping("redirectListadoCuentas.do")
	public ModelAndView eventoRedirectListadoCuentas() {
		ModelAndView mv = new ModelAndView();
		List<Cuenta> lstCuentas = nCuenta.obtenerCuentas();
		mv.addObject("lstCuentas", lstCuentas);
		mv.setViewName("ListadoCuentas");
		mv.addObject("PageTitle", "Listado Cuentas");
		return mv;
	}

	@RequestMapping("redirectAltaCuentaCliente.do")
	public ModelAndView eventoRedirectAltaCuentaCliente() {
		ModelAndView mv = new ModelAndView();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		mv.setViewName("AltaCuentaCliente");
		List<TipoCuenta> lstTipoCuenta = nTipoCuenta.obtenerTipoCuentas();
		List<Cliente> lstCliente = nCli.obtenerClientes();
		mv.addObject("fecha", dateFormat.format(date));
		mv.addObject("ListadoClientes", lstCliente);
		mv.addObject("lstTipoCuenta", lstTipoCuenta);
		mv.addObject("PageTitle", "Alta Cuenta");
		return mv;
	}

	@RequestMapping("redirectListaClientes.do")
	public ModelAndView eventoRedirectListaClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoClientes");
		List<Cliente> lstCliente = nCli.obtenerClientes();
		mv.addObject("ListadoClientes", lstCliente);
		mv.addObject("PageTitle", "Listado Clientes");
		return mv;
	}


	@RequestMapping("redirectListaUsuarios.do")
	public ModelAndView eventoRedirectListaUsuarios() {
		ModelAndView mv = new ModelAndView();
		List<Usuario> lstUsuario = nUser.obtenerUsuarios();
		mv.setViewName("ListadoUsuarios");
		mv.addObject("lstUsuarios", lstUsuario);
		mv.addObject("PageTitle", "Listado Usuarios");
		return mv;
	}

	@RequestMapping("redirectListaCuentas.do")
	public ModelAndView eventoRedirectListaCuentas() {
		ModelAndView mv = new ModelAndView();
		List<Cuenta> lstCuentas = nCuenta.obtenerCuentas();
		mv.addObject("lstCuentas", lstCuentas);
		mv.setViewName("ListadoCuentas");
		mv.addObject("PageTitle", "Listado Cuentas");
		return mv;
	}

	@RequestMapping("redirectAltaCliente.do")
	public ModelAndView eventoRedirectAltaCliente() {
		ModelAndView mv = new ModelAndView();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		List<Localidad> lstLoc = nLoc.obtenerLocalidades();
		List<Provincia> lstProv = nProv.obtenerProvincias();
		mv.addObject("lstLoc", lstLoc);
		mv.addObject("lstProv", lstProv);
		mv.addObject("fecha", dateFormat.format(date));
		mv.setViewName("AltaCliente");
		mv.addObject("PageTitle", "Registrar Cliente");
		return mv;
	}

	@RequestMapping(value = "cerrarSession.do", method = RequestMethod.GET)
	public ModelAndView eventoCerrarSesion() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Username", "");
		mv.setViewName("Login");
		mv.addObject("PageTitle", "Login");
		return mv;
	}

}
