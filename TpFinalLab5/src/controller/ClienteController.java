package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import configCapas.ConfigEnt;
import configCapas.ConfigNeg;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Localidad;
import entidad.Provincia;
import entidad.TipoCuenta;
import entidad.Transaccion;
import entidad.Usuario;
import negocioImp.ClienteNImp;
import negocioImp.CuentaNImp;
import negocioImp.LocalidadNImp;
import negocioImp.ProvinciaNImp;
import negocioImp.TipoCuentaNImp;
import negocioImp.TransaccionNImp;
import negocioImp.UsuarioNImp;

@Controller
@SessionAttributes(value = "name")
@Scope()
public class ClienteController {

	private ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigNeg.class);
	UsuarioNImp nUser = (UsuarioNImp) appContext.getBean("usuarioNImp");
	ClienteNImp nCli = (ClienteNImp) appContext.getBean("clienteNImp");
	LocalidadNImp nLoc = (LocalidadNImp) appContext.getBean("localidadNImp");
	ProvinciaNImp nProv = (ProvinciaNImp) appContext.getBean("provinciaNImp");
	CuentaNImp nCuenta = (CuentaNImp) appContext.getBean("cuentaNImp");
	TipoCuentaNImp nTipoCuenta = (TipoCuentaNImp) appContext.getBean("tipoCuentaNImp");
	TransaccionNImp nTransaccion = (TransaccionNImp) appContext.getBean("transaccionNImp");

	private ApplicationContext appContextEntidad = new AnnotationConfigApplicationContext(ConfigEnt.class);
	Usuario user = (Usuario) appContextEntidad.getBean("usuario");
	Cliente cli = (Cliente) appContextEntidad.getBean("cliente");
	Localidad loc = (Localidad) appContextEntidad.getBean("localidad");
	Provincia prov = (Provincia) appContextEntidad.getBean("provincia");
	Cuenta cuenta = (Cuenta) appContextEntidad.getBean("cuenta");
	TipoCuenta tCuenta = (TipoCuenta) appContextEntidad.getBean("tipoCuenta");
	Transaccion transaccion = (Transaccion) appContextEntidad.getBean("transaccion");

	@RequestMapping(value = "/redirectTransferenciaCliente.do", method = RequestMethod.GET)
	public ModelAndView eventoRedirectTransferenciaClientes(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		cli = nCli.obtenerClientexUsuario(request.getSession().getAttribute("name").toString());
		if (cli != null) {
			if (cli.getEstado() == 1) {
				List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cli.getDNI());
				// List<Cuenta> cuentaDestino = nCuenta.ob
				mv.setViewName("TransferenciaClientes");
				mv.addObject("PageTitle", "Transferencia a Clientes");
				mv.addObject("cuentas", cuentas);
			} else {
				mv.setViewName("MenuPrincipal");
				mv.addObject("PageTitle", "Menu Principal");
				mv.addObject("Msg", "Error el cliente aun no se aprobo");
			}
		} else {
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
			mv.addObject("Msg", "Error el cliente no se encuentra registrado");
		}
		return mv;
	}

	@RequestMapping("/redirectTransferenciaPropias.do")
	public ModelAndView eventoRedirectTransferenciaPropias(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		cli = nCli.obtenerClientexUsuario(request.getSession().getAttribute("name").toString());
		if (cli != null) {
			if (cli.getEstado() == 1) {
				List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cli.getDNI());
				// List<Cuenta> cuentaDestino = nCuenta.ob
				mv.setViewName("TransferenciaPropias");
				mv.addObject("PageTitle", "Transferencia Propias");
				mv.addObject("cuentas", cuentas);
			} else {
				mv.setViewName("MenuPrincipal");
				mv.addObject("PageTitle", "Menu Principal");
				mv.addObject("Msg", "Error el cliente aun no se aprobo");
			}
		} else {
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
			mv.addObject("Msg", "Error el cliente no se encuentra registrado");
		}
		return mv;
	}

	@RequestMapping("/changeAccount.do")
	public ModelAndView eventoCambiarCuenta(HttpServletRequest request, String ddlCBUOrigen) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OperacionesCuenta");
		cli = nCli.obtenerClientexUsuario(request.getSession().getAttribute("name").toString());
		List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cli.getDNI());
		mv.addObject("cuentas", cuentas);
		List<Transaccion> transacciones = nTransaccion.obtenerTransaccionesCuenta(Integer.parseInt(ddlCBUOrigen));
		mv.addObject("cuentas", cuentas);
		mv.addObject("transacciones", transacciones);
		mv.addObject("PageTitle", "Operaciones Cuenta");
		return mv;
	}

	// redireccionar a operaciones cuenta
	@RequestMapping("/redirectOperacionesCuenta.do")
	public ModelAndView eventoRedirectOperecionesCuenta(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OperacionesCuenta");
		cli = nCli.obtenerClientexUsuario(request.getSession().getAttribute("name").toString());
		if (cli != null) {
		List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cli.getDNI());
		mv.addObject("cuentas", cuentas);
		Cuenta primeraCuenta = new Cuenta();
		for (Cuenta cuenta : cuentas) {
			primeraCuenta = cuenta;
			break;
		}
		List<Transaccion> transacciones = nTransaccion.obtenerTransaccionesCuenta(primeraCuenta.getCBU());
		mv.addObject("cuentas", cuentas);
		mv.addObject("transacciones", transacciones);
		mv.addObject("PageTitle", "Operaciones Cuenta");
		} else {
			mv.setViewName("MenuPrincipal");
			mv.addObject("PageTitle", "Menu Principal");
			mv.addObject("Msg", "Error el cliente no se encuentra registrado");
		}
		return mv;
	}

	public boolean saveTransaction(String txtCBU, String txtMonto, int CBUOrigen, String txtDescription) {
		Date date = new Date();
		transaccion.setCBU_Egreso(CBUOrigen);
		transaccion.setCBU_Ingresa(Integer.parseInt(txtCBU));
		transaccion.setDescripcion(txtDescription);
		transaccion.setMonto(Double.parseDouble(txtMonto));
		transaccion.setFecha(date);
		if (nTransaccion.insertarTransaccion(transaccion)) {
			return true;
		} else {
			return false;
		}

	}

	@RequestMapping("/transferClient.do")
	public ModelAndView eventoTrasferClient(String txtCBU, String txtMonto, String ddlCBUOrigen,
			String txtDescription) {
		ModelAndView mv = new ModelAndView();
		cuenta = nCuenta.buscarCuenta(Integer.parseInt(ddlCBUOrigen));
		List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cuenta.getDNI());
		if (!txtCBU.isEmpty() && !txtMonto.isEmpty()) {
			if (nCuenta.verificarCuenta(Integer.parseInt(txtCBU))) {
				Cuenta cuentaDestino = nCuenta.buscarCuenta(Integer.parseInt(txtCBU));
				if (cuenta.getSaldo() >= Double.parseDouble(txtMonto)) {
					cuenta.setSaldo((cuenta.getSaldo() - Double.parseDouble(txtMonto)));
					nCuenta.modificar(cuenta);
					cuentaDestino.setSaldo(cuentaDestino.getSaldo() + Double.parseDouble(txtMonto));
					nCuenta.modificar(cuentaDestino);

					if (saveTransaction(txtCBU, txtMonto, cuenta.getCBU(), txtDescription)) {
						mv.addObject("Msg", "Transferencia realizada exitosamente");
					} else {
						mv.addObject("Msg", "Transferencia realizada exitosamente");
					}
				} else {
					mv.addObject("Msg", "No posee suficiente saldo para realizar la transaccion");
				}

			} else {
				mv.addObject("Msg", "El cbu ingresado no pertenece a ninguna cuenta existente");
			}
		} else {
			mv.addObject("Msg", "Error en los datos ingresados");
		}
		mv.addObject("cuentas", cuentas);
		mv.setViewName("TransferenciaClientes");
		mv.addObject("PageTitle", "Transferencia a Clientes");
		return mv;
	}

	@RequestMapping("/transferMyAccount.do")
	public ModelAndView eventoTrasferMyAccount(String ddlCBUDestino, String txtMonto, String ddlCBUOrigen,
			String txtDescription) {
		ModelAndView mv = new ModelAndView();
		cuenta = nCuenta.buscarCuenta(Integer.parseInt(ddlCBUOrigen));
		List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cuenta.getDNI());
		if (!ddlCBUDestino.isEmpty() && !txtMonto.isEmpty()) {
			if (!ddlCBUDestino.equals(ddlCBUOrigen)) {
				if (nCuenta.verificarCuenta(Integer.parseInt(ddlCBUDestino))) {
					Cuenta cuentaDestino = nCuenta.buscarCuenta(Integer.parseInt(ddlCBUDestino));
					if (cuenta.getSaldo() >= Double.parseDouble(txtMonto)) {
						cuenta.setSaldo((cuenta.getSaldo() - Double.parseDouble(txtMonto)));
						nCuenta.modificar(cuenta);
						cuentaDestino.setSaldo(cuentaDestino.getSaldo() + Double.parseDouble(txtMonto));
						nCuenta.modificar(cuentaDestino);

						if (saveTransaction(ddlCBUDestino, txtMonto, cuenta.getCBU(), txtDescription)) {
							mv.addObject("Msg", "Transferencia realizada exitosamente");
						} else {
							mv.addObject("Msg", "Transferencia realizada exitosamente");
						}
					} else {
						mv.addObject("Msg", "No posee suficiente saldo para realizar la transaccion");
					}

				} else {
					mv.addObject("Msg", "El cbu ingresado no pertenece a ninguna cuenta existente");
				}
			} else {
				mv.addObject("Msg", "No puede transferirse a la misma cuenta");
			}
		} else {
			mv.addObject("Msg", "Error en los datos ingresados");
		}
		mv.addObject("cuentas", cuentas);
		mv.setViewName("TransferenciaPropias");
		mv.addObject("PageTitle", "Transferencia Propias");
		return mv;
	}

	@RequestMapping("/redirectAltaCliente.do")
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

	@RequestMapping("/addClient.do")
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
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			mv.addObject("lstLoc", lstLoc);
			mv.addObject("lstProv", lstProv);
			mv.setViewName("AltaCliente");
			mv.addObject("PageTitle", "Registrar Cliente");
			mv.addObject("fecha", dateFormat.format(date));
			mv.addObject("Msg", "Error, los datos ingresados no son correctos.");
		}
		mv.addObject("Usuario", user.getUsername());
		
		return mv;
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

}
