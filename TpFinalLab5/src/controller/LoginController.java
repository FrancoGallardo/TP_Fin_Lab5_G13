package controller;

import javax.jws.WebParam.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import negocioImp.ClienteNImp;
import negocioImp.LocalidadNImp;
import negocioImp.ProvinciaNImp;
import negocioImp.UsuarioNImp;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Provincia;
import entidad.TipoCuenta;
import entidad.Usuario;

@Controller
public class LoginController {
	ModelAndView mv = new ModelAndView();
	UsuarioNImp nUser = new UsuarioNImp();
	ClienteNImp nCli = new ClienteNImp();
	LocalidadNImp nLoc = new LocalidadNImp();
	ProvinciaNImp nProv = new ProvinciaNImp();
	Usuario user = new Usuario();
	Cliente cli  = new Cliente();
	Localidad loc = new Localidad();
	Provincia prov  = new Provincia();
	
	public void insertarLocalidades() {
		prov.setIdProvincia(0);
		prov.setDescripcion("Buenos Aires");
		
		loc.setDescripcion("San Fernando");
		loc.setProvincia(prov);
		nLoc.insertarLocalidad(loc);
		loc.setDescripcion("Tigre");
		loc.setProvincia(prov);
		nLoc.insertarLocalidad(loc);
	}
	
	public void insertarProvincia() {
		prov.setDescripcion("Buenos Aires");
		nProv.insertarProvincia(prov);
		prov.setDescripcion("Salta");
		nProv.insertarProvincia(prov);
		prov.setDescripcion("Cordoba");
		nProv.insertarProvincia(prov);
		prov.setDescripcion("Entre R�os");
		nProv.insertarProvincia(prov);
	}
	
	//redireccionar al menu principal por el login
	@RequestMapping("login.do")
	public ModelAndView eventoRedirectMenu(String txtUsuario , String txtPassword) {
		user = nUser.verificarUsuario(txtUsuario, txtPassword);	
		System.out.println(user.getUsername());
		if(user.getUsername().equals("admin")) {
			List<Cliente> lstCliente = nCli.obtenerClientes();
			mv.setViewName("ListadoClientes");
			mv.addObject("ListadoClientes", lstCliente);
			mv.addObject("PageTitle", "Listado Clientes");
		} else {
			System.out.println("else");
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
		}
		mv.addObject("Usuario", user.getUsername());
		return mv;
	}
	
	public void verificarCliente(String User, String txtDocumento, String txtNombre, String txtApellido, String ddlSexo, String ddlUsuario, 
			 String txtNacionalidad, String ddlProvincia, String ddlLocalidad, String txtDireccion, String dtFechaNac) {
		user.setUsername(User);
		Date FechaNac;
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		prov.setIdProvincia(Integer.parseInt(ddlProvincia));
		loc.setProvincia(prov);
		loc.setIdLocalidad(Integer.parseInt(ddlLocalidad));
		try {
			FechaNac=new SimpleDateFormat("yyyy-mm-dd").parse(dtFechaNac);
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
	}
	
	@RequestMapping("addClient.do")
	public ModelAndView eventoAddCliente(String User, String txtDocumento, String txtNombre, String txtApellido, String ddlSexo, String ddlUsuario, 
			 String txtNacionalidad, String ddlProvincia, String ddlLocalidad, String txtDireccion, String dtFechaNac) {
		verificarCliente(User, txtDocumento, txtNombre, txtApellido, ddlSexo, ddlUsuario, 
				 txtNacionalidad, ddlProvincia, ddlLocalidad, txtDireccion, dtFechaNac);
		nCli.insertarCliente(cli);	
		mv.setViewName("MenuPrincipal");
		mv.addObject("PageTitle", "Menu Principal");
		mv.addObject("Usuario", user.getUsername());
		return mv;
	}
	
	//redireccionar al menu principal tras registrarse
	@RequestMapping("register.do")
	public ModelAndView eventoRegister(String txtUsuario , String txtContrasenia , String txtRepitPassword) {
		ModelAndView mv = new ModelAndView();
		if(txtContrasenia.equals(txtRepitPassword)) {
			user.setPassword(txtContrasenia);
			user.setUsername(txtUsuario);
			user.setEstado(true);
			user.setTipoUsuario("Cliente");
			nUser.insertarUsuario(user);
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
			mv.addObject("Usuario", user.getUsername());
		} else {
			mv.setViewName("Register");
			mv.addObject("PageTitle", "Registrarse");
		}
		return mv;
	}
	
	//Cambiar contrase�a redirecciona al login
	@RequestMapping("forgotPassword.do")
	public ModelAndView eventoForgotPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		mv.addObject("PageTitle", "Cambiar Contraseña");
		return mv;
	}
	
	//redireccionar a login
	@RequestMapping("redirectLogin.do")
	public ModelAndView eventoInicarAplicaciones() {
		ModelAndView mv = new ModelAndView();
		insertarProvincia();
		insertarLocalidades();
		mv.setViewName("Login");
		mv.addObject("PageTitle", "Login");
		return mv;
	}
	
	//redireccionar a register
	@RequestMapping("redirectRegister.do")
	public ModelAndView eventoRedirectRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Register");
		mv.addObject("PageTitle", "Registrarse");
		return mv;
	}
	
	//redireccionar a forgot password
	@RequestMapping("redirectForgotPassword.do")
	public ModelAndView eventoRedirectForgotPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ForgotPassword");
		mv.addObject("PageTitle", "Cambiar Contraseña");
		return mv;
	}
	
	//redireccionar a operaciones cuenta
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
		mv.setViewName("ListadoCuentas");
		mv.addObject("PageTitle", "Listado Cuentas");
		return mv;
	}
	
	@RequestMapping("redirectListadoClientes.do")
	public ModelAndView eventoRedirectListadoClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoClientes");
		mv.addObject("PageTitle", "Listado Clientes");
		return mv;
	}
	
	@RequestMapping("redirectAltaCuentaCliente.do")
	public ModelAndView eventoRedirectAltaCuentaCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AltaCuentaCliente");
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
		mv.setViewName("ListadoUsuarios");
		mv.addObject("PageTitle", "Listado Usuarios");
		return mv;
	}
	
	@RequestMapping("redirectListaCuentas.do")
	public ModelAndView eventoRedirectListaCuentas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoCuentas");
		mv.addObject("PageTitle", "Listado Cuentas");
		return mv;
	}
	
	@RequestMapping("redirectAltaCliente.do")
	public ModelAndView eventoRedirectAltaCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AltaCliente");
		mv.addObject("PageTitle", "Registrar Cliente");
		return mv;
	}
	

}
