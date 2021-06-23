package controller;

import javax.jws.WebParam.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	//redireccionar al menu principal por el login
	@RequestMapping("login.do")
	public ModelAndView eventoRedirectMenu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MenuPrincipal");
		mv.addObject("PageTitle", "Menu Principal");
		return mv;
	}
	
	//redireccionar al menu principal tras registrarse
	@RequestMapping("register.do")
	public ModelAndView eventoRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MenuPrincipal");
		mv.addObject("PageTitle", "Registrarse");
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
		mv.setViewName("Login");
		mv.addObject("PageTitle", "Login");
		return mv;
	}
	
	//redireccionar a register
	@RequestMapping("redirectRegister.do")
	public ModelAndView eventoRedirectRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Register");
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
	
}
