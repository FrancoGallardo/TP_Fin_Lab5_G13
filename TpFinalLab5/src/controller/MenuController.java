package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
	
	@RequestMapping("redirectMenuPrincipal.do")
	public ModelAndView eventoRedirectMenu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MenuPrincipal");
		return mv;
	}
	
	@RequestMapping("redirectTransferenciaCliente.do")
	public ModelAndView eventoRedirectTransferenciaClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("TransferenciaClientes");
		return mv;
	}
	
	@RequestMapping("redirectTransferenciaPropias.do")
	public ModelAndView eventoRedirectTransferenciaPropias() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("TransferenciaPropias");
		return mv;
	}
	

	

}
