package negocioImp;

import java.util.List;

import entidad.Transaccion;
import funcionesDAOImp.TransaccionesDAOImp;
import negocio.TransaccionN;

public class TransaccionNImp implements TransaccionN{

	TransaccionesDAOImp transaccionDAO = new TransaccionesDAOImp();
	
	@Override
	public boolean insertarTransaccion(Transaccion transaccion) {
		return transaccionDAO.insertarTransaccion(transaccion);
	}

	@Override
	public boolean buscarTransaccion(int idTransaccion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transaccion> obtenerTransacciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Transaccion transaccion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transaccion verificarTransaccion(int idTransaccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaccion> obtenerTransaccionesCuenta(int cbu) {
		return transaccionDAO.obtenerTransaccionesCuenta(cbu);
	}

}
