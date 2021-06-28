package negocio;

import java.util.List;

import entidad.TipoCuenta;

public interface TipoCuentaN {

	public boolean insertarTipoCuenta(TipoCuenta transaccion);
	public boolean buscarTipoCuenta(int codTipoCuenta);
	public List<TipoCuenta> obtenerTipoCuentas();
	public boolean modificar(TipoCuenta transaccion);
	public TipoCuenta verificarTransaccion(int codTipoCuenta);
	
}
