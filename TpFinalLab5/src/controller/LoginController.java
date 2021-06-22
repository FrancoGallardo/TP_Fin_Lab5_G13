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
		return mv;
	}
	
	//redireccionar al menu principal tras registrarse
	@RequestMapping("register.do")
	public ModelAndView eventoRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MenuPrincipal");
		return mv;
	}
	
	//Cambiar contraseña redirecciona al login
	@RequestMapping("forgotPassword.do")
	public ModelAndView eventoForgotPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
	//redireccionar a login
	@RequestMapping("redirectLogin.do")
	public ModelAndView eventoInicarAplicaciones() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
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
		return mv;
	}
	
	//redireccionar a operaciones cuenta
	@RequestMapping("redirectOperacionesCuenta.do")
	public ModelAndView eventoRedirectOperecionesCuenta() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OperacionesCuenta");
		return mv;
	}
	
	
}
