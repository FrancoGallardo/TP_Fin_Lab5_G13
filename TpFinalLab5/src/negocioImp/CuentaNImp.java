package negocioImp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Cuenta;
import funcionesDAOImp.ClienteDAOImp;
import funcionesDAOImp.CuentaDAOImp;
import negocio.CuentaN;

public class CuentaNImp implements CuentaN{

	CuentaDAOImp cuentaDAO;
	private ApplicationContext appContext;
	
	public CuentaNImp() {
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		cuentaDAO = (CuentaDAOImp) appContext.getBean("CuentaDAO");
	}
	
	@Override
	public boolean insertarCuenta(Cuenta cuenta) {
		return cuentaDAO.insertarCuenta(cuenta);
	}

	@Override
	public Cuenta buscarCuenta(int CBU) {
		return cuentaDAO.obtenerCuenta(CBU);
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		return cuentaDAO.obtenerCuentas();
	}

	@Override
	public boolean modificar(Cuenta cuenta) {
		return cuentaDAO.modificar(cuenta);
	}

	@Override
	public boolean verificarCuenta(int CBU) {
		return cuentaDAO.verificarCuenta(CBU);
	}

	@Override
	public List<Cuenta> obtenerCuentasCliente(int DNI) {
		return cuentaDAO.obtenerCuentasCliente(DNI);
	}

}
