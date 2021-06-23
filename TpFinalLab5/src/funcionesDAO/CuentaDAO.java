package funcionesDAO;

import java.util.List;
import entidad.Cuenta;

public interface CuentaDAO {

	public boolean insertarCuenta(Cuenta user);
	public Cuenta obtenerCuenta(int id);
	public boolean buscarCuenta(int id);
	public List<Cuenta> obtenerCuentas();
	public boolean modificar(Cuenta cuenta);
	
}
