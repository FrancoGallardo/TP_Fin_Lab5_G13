package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Localidad;
import entidad.Provincia;
import entidad.TipoCuenta;
import entidad.Usuario;
import negocioImp.ClienteNImp;
import negocioImp.CuentaNImp;
import negocioImp.LocalidadNImp;
import negocioImp.ProvinciaNImp;
import negocioImp.TipoCuentaNImp;
import negocioImp.UsuarioNImp;

@Controller
public class AdminController {

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
	
	
	@RequestMapping("/redirectListaClientes.do")
	public ModelAndView eventoRedirectListaClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoClientes");
		List<Cliente> lstCliente = nCli.obtenerClientes();
		mv.addObject("ListadoClientes", lstCliente);
		mv.addObject("PageTitle", "Listado Clientes");
		return mv;
	}

	@RequestMapping("/redirectListaUsuarios.do")
	public ModelAndView eventoRedirectListaUsuarios() {
		ModelAndView mv = new ModelAndView();
		List<Usuario> lstUsuario = nUser.obtenerUsuarios();
		mv.setViewName("ListadoUsuarios");
		mv.addObject("lstUsuarios", lstUsuario);
		mv.addObject("PageTitle", "Listado Usuarios");
		return mv;
	}

	@RequestMapping("/redirectListaCuentas.do")
	public ModelAndView eventoRedirectListaCuentas() {
		ModelAndView mv = new ModelAndView();
		List<Cuenta> lstCuentas = nCuenta.obtenerCuentas();
		mv.addObject("lstCuentas", lstCuentas);
		mv.setViewName("ListadoCuentas");
		mv.addObject("PageTitle", "Listado Cuentas");
		return mv;
	}
	
	@RequestMapping("/redirectListadoCuentas.do")
	public ModelAndView eventoRedirectListadoCuentas() {
		ModelAndView mv = new ModelAndView();
		List<Cuenta> lstCuentas = nCuenta.obtenerCuentas();
		mv.addObject("lstCuentas", lstCuentas);
		mv.setViewName("ListadoCuentas");
		mv.addObject("PageTitle", "Listado Cuentas");
		return mv;
	}
	
	@RequestMapping("/redirectAltaCuentaCliente.do")
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

	@RequestMapping("/redirectDetails.do")
	public ModelAndView eventoRedireccionarDetalles(String DNI) {
		ModelAndView mv = new ModelAndView();
		cli = nCli.buscarCliente(Integer.parseInt(DNI));
		mv.setViewName("DatosCliente");
		mv.addObject("PageTitle", "Datos Cliente");
		mv.addObject("cliente", cli);
		return mv;
	}

	@RequestMapping("/modifyState.do")
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

}
