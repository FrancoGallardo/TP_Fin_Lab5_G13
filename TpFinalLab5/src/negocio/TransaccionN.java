package negocio;

import java.util.List;

import entidad.Transaccion;

public interface TransaccionN {

	public boolean insertarTransaccion(Transaccion transaccion);
	public boolean buscarTransaccion(int idTransaccion);
	public List<Transaccion> obtenerTransacciones();
	public boolean modificar(Transaccion transaccion);
	public Transaccion verificarTransaccion(int idTransaccion);
	public List<Transaccion> obtenerTransaccionesCuenta(int cbu);
}
