package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import configCapas.ConfigDAO;
import configCapas.ConfigEnt;
import configCapas.ConfigNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import funcionesDAOImp.TransaccionesDAOImp;

@Controller
@SessionAttributes(value="name")
@Scope()
public class LoginController {
	
	private ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigNeg.class);
	UsuarioNImp nUser = (UsuarioNImp) appContext.getBean("usuarioNImp");
	ClienteNImp nCli = (ClienteNImp) appContext.getBean("clienteNImp");
	LocalidadNImp nLoc = (LocalidadNImp) appContext.getBean("localidadNImp");
	ProvinciaNImp nProv = (ProvinciaNImp) appContext.getBean("provinciaNImp");
	CuentaNImp nCuenta = (CuentaNImp) appContext.getBean("cuentaNImp");
	TipoCuentaNImp nTipoCuenta = (TipoCuentaNImp) appContext.getBean("tipoCuentaNImp");

	private ApplicationContext appContextEntidad = new AnnotationConfigApplicationContext(ConfigEnt.class);
	Usuario user = (Usuario) appContextEntidad.getBean("usuario");
	Cliente cli = (Cliente) appContextEntidad.getBean("cliente");
	Localidad loc = (Localidad) appContextEntidad.getBean("localidad");
	Provincia prov = (Provincia) appContextEntidad.getBean("provincia");
	Cuenta cuenta = (Cuenta) appContextEntidad.getBean("cuenta");
	TipoCuenta tCuenta = (TipoCuenta) appContextEntidad.getBean("tipoCuenta");

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
		prov.setDescripcion("Entre R???os");
		nProv.insertarProvincia(prov);
	}

	public void insertarTipoCuenta() {
		tCuenta.setTipoCuenta("Pesos");
		nTipoCuenta.insertarTipoCuenta(tCuenta);
		tCuenta.setTipoCuenta("Dolares");
		nTipoCuenta.insertarTipoCuenta(tCuenta);
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
	
	// redireccionar al menu principal por el login
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView eventoRedirectMenu(String txtUsuario, String txtContrasenia, HttpServletRequest request) {
		int x = UserExist(txtUsuario,  txtContrasenia);
		request.getSession().setAttribute("name", "");
		request.getSession().invalidate();
		System.out.println(txtUsuario);
		ModelAndView mv = new ModelAndView();
		if (x==1)
		{
			List<Cliente> lstCliente = nCli.obtenerClientes();
			mv.setViewName("ListadoClientes");
			mv.addObject("ListadoClientes", lstCliente);
			mv.addObject("PageTitle", "Listado Clientes");
			mv.addObject("name", user.getUsername());
		} 
		else if(x==2)
		{
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");	
			mv.addObject("name", user.getUsername());
		}
		else if(x==0) 
		{
			mv.setViewName("Login");
			mv.addObject("PageTitle", "Login");
			mv.addObject("Msg", "Error, los datos ingresados no son correctos.");
		}
		return mv;
	}

	// redireccionar al menu principal tras registrarse
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView eventoRegister(String txtUsuario, String txtContrasenia, String txtRepitPassword, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
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
				mv.addObject("Msg", "Usuario registrado correctamente.");
				request.getSession().setAttribute("name", user.getUsername());
				mv.addObject("name", user.getUsername());
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
			mv.addObject("Msg", "Error, las contrase??as ingresadas no son iguales.");
		}
		return mv;
	}

	// Cambiar contrasena redirecciona al login
	@RequestMapping("/forgotPassword.do")
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
					mv.addObject("Msg", "Contrase?a modificada correctamente");
				} else {
					mv.setViewName("ForgotPassword");
					mv.addObject("PageTitle", "Cambiar Contrase???a");
					mv.addObject("Msg", "Error, no se logro modificar la Contrase?a.");
				}
			} else {
				mv.setViewName("ForgotPassword");
				mv.addObject("PageTitle", "Cambiar Contrase???a");
				mv.addObject("Msg", "Error, el usuario ingresado no se encuentra registrado.");
			}
		} else {
			mv.setViewName("ForgotPassword");
			mv.addObject("PageTitle", "Cambiar Contrase?a");
			mv.addObject("Msg", "Error, las Contrase?as no son iguales.");
		}
		return mv;
	}

	// redireccionar a login
	@RequestMapping("/redirectLogin.do")
	public ModelAndView eventoRedirectLogin() {
		ModelAndView mv = new ModelAndView();
		// insertarProvincias();
		// insertarLocalidades();
		mv.setViewName("Login");
		mv.addObject("PageTitle", "Login");
		return mv;
	}
	
	// redireccionar a index
	@RequestMapping("/redirectIndex.do")
	public ModelAndView eventoInicarAplicacion() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Index");
		mv.addObject("PageTitle", "Index");
		return mv;
	}

	// redireccionar a register
	@RequestMapping("/redirectRegister.do")
	public ModelAndView eventoRedirectRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Register");
		mv.addObject("PageTitle", "Registrarse");
		return mv;
	}

	// redireccionar a forgot password
	@RequestMapping("/redirectForgotPassword.do")
	public ModelAndView eventoRedirectForgotPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ForgotPassword");
		mv.addObject("PageTitle", "Cambiar Contrase???a");
		return mv;
	}

	@RequestMapping("/redirectMenuPrincipal.do")
	public ModelAndView eventoRedirectMenuPrincipal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MenuPrincipal");
		mv.addObject("PageTitle", "Menu Principal");
		return mv;
	}

	@RequestMapping(value = "/cerrarSession.do", method = RequestMethod.GET)
	public ModelAndView eventoCerrarSesion(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		request.getSession().invalidate();
		request.getSession(false);
		HttpSession session=request.getSession();  
	    session.invalidate();  
		mv.setViewName("Index");
		mv.addObject("PageTitle", "Index");
	    return mv;
	}

}
