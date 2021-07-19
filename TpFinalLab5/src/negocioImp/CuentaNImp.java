package negocioImp;

import java.util.List;

import entidad.Cuenta;
import funcionesDAOImp.CuentaDAOImp;
import negocio.CuentaN;

public class CuentaNImp implements CuentaN{

	CuentaDAOImp cuentaDAO = new CuentaDAOImp();
	
	@Override
	public boolean insertarCuenta(Cuenta cuenta) {
		return cuentaDAO.insertarCuenta(cuenta);
	}

	@Override
	public Cuenta buscarCuenta(int CBU) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		return cuentaDAO.obtenerCuentas();
	}

	@Override
	public boolean modificar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificarCuenta(int CBU) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cuenta> obtenerCuentasCliente(int DNI) {
		return cuentaDAO.obtenerCuentasCliente(DNI);
	}

}
