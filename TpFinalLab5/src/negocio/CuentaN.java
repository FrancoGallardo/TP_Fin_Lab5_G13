package negocio;

import java.util.List;

import entidad.Cuenta;

public interface CuentaN {

	public boolean insertarCuenta(Cuenta cuenta);
	public Cuenta buscarCuenta(int CBU);
	public List<Cuenta> obtenerCuentas();
	public List<Cuenta> obtenerCuentasCliente(int id);
	public boolean modificar(Cuenta cuenta);
	public boolean verificarCuenta(int CBU);
	public int contarCuentas(int DNI);
}
