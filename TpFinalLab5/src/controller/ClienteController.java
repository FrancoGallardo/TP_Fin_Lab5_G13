package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class ClienteController {
	
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
	
	@RequestMapping(value="/redirectTransferenciaCliente.do" , method = RequestMethod.GET)
	public ModelAndView eventoRedirectTransferenciaClientes(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		cli = nCli.obtenerClientexUsuario(request.getSession().getAttribute("name").toString());
		List<Cuenta> cuentas = nCuenta.obtenerCuentasCliente(cli.getDNI());
		//List<Cuenta> cuentaDestino = nCuenta.ob
		mv.setViewName("TransferenciaClientes");
		mv.addObject("PageTitle", "Transferencia a Clientes");
		mv.addObject("cuentas", cuentas);
		//mv.addObject("cuentaDestino", cuentaDestino);
		return mv;
	}

	@RequestMapping("/redirectTransferenciaPropias.do")
	public ModelAndView eventoRedirectTransferenciaPropias() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("TransferenciaPropias");
		mv.addObject("PageTitle", "Transferencias a Cuentas Propias");
		return mv;
	}
	
	// redireccionar a operaciones cuenta
	@RequestMapping("/redirectOperacionesCuenta.do")
	public ModelAndView eventoRedirectOperecionesCuenta() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OperacionesCuenta");
		mv.addObject("PageTitle", "Operaciones Cuenta");
		return mv;
	}
	
	@RequestMapping("/transferClient.do")
	public ModelAndView eventoTrasferClient(String txtCBU , String txtMonto , String ddlCBUOrigen) {
		ModelAndView mv = new ModelAndView();
		Cuenta cuentaDestino = nCuenta.buscarCuenta(Integer.parseInt(txtCBU));
		if(cuentaDestino != null) {
			cuenta = nCuenta.buscarCuenta(Integer.parseInt(ddlCBUOrigen));
			if(cuenta.getSaldo() >= Double.parseDouble(txtMonto)) {
				cuenta.setSaldo((cuenta.getSaldo() - Double.parseDouble(txtMonto)));
				nCuenta.modificar(cuenta);
				cuentaDestino.setSaldo(cuentaDestino.getSaldo() + Double.parseDouble(txtMonto));
				nCuenta.modificar(cuentaDestino);
				mv.addObject("Msg", "Transferencia realizada exitosamente");
			} else {
				mv.addObject("Msg", "No posee suficiente saldo para realizar la transaccion");
			}
		
		} else {
			mv.addObject("Msg", "El cbu ingresado no pertenece a ninguna cuenta existente");
		}
		mv.setViewName("TransferenciaClientes");
		mv.addObject("PageTitle", "Transferencia a Clientes");
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
			mv.addObject("lstLoc", lstLoc);
			mv.addObject("lstProv", lstProv);
			mv.setViewName("AltaCliente");
			mv.addObject("PageTitle", "Registrar Cliente");
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
