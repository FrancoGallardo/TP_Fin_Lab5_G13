package funcionesDAO;

import java.util.List;
import entidad.Cuenta;
import entidad.Usuario;

public interface CuentaDAO {

	public boolean insertarCuenta(Cuenta cuenta);
	public Cuenta obtenerCuenta(int CBU);
	public boolean verificarCuenta(int cbu);
	public List<Cuenta> obtenerCuentas();
	public List<Cuenta> obtenerCuentasCliente(int DNI);
	public boolean modificar(Cuenta cuenta);
	public void Finalizar();
	public void Inicializar();
	
}
