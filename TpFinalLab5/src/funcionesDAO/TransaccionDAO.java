package funcionesDAO;

import java.util.List;
import entidad.Transaccion;

public interface TransaccionDAO {

	public boolean insertarTransaccion(Transaccion transaccion);
	public Transaccion obtenerTransaccion(int id);
	public boolean buscarTransaccion(int id);
	public List<Transaccion> obtenerTransaccion();
	public boolean modificar(Transaccion transaccion);
	public void Finalizar();
	public void Inicializar();
}
