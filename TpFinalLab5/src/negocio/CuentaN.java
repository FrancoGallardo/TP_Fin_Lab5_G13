package negocio;

import java.util.List;

import entidad.Cuenta;

public interface CuentaN {

	public boolean insertarCuenta(Cuenta cuenta);
	public boolean buscarCuenta(int CBU);
	public List<Cuenta> obtenerCuentas();
	public boolean modificar(Cuenta cuenta);
	public Cuenta verificarCuenta(int CBU);
	
}
