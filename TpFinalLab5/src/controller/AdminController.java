package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@SessionAttributes(value="name")
@Scope()
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
	
	public boolean verificarCuenta(String txtCBU, String txtFechaCreacion, String ddlTipoCuenta, String txtSaldo, String txtUsuario) {
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
						cuenta.setDNI(Integer.parseInt(txtUsuario));
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
	
	@RequestMapping("/registerAccount.do")
	public ModelAndView eventoRegistrarCuenta(String txtUsuario, String txtCBU, String txtFechaCreacion, String ddlTipoCuenta,
			String txtSaldo) {
		ModelAndView mv = new ModelAndView();
		boolean verificar = verificarCuenta(txtCBU, txtFechaCreacion, ddlTipoCuenta, txtSaldo, txtUsuario);
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
