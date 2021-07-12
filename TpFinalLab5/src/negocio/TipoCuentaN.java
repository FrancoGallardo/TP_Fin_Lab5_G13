package negocio;

import java.util.List;

import entidad.TipoCuenta;

public interface TipoCuentaN {

	public boolean insertarTipoCuenta(TipoCuenta tipoCuenta);
	public boolean buscarTipoCuenta(int codTipoCuenta);
	public List<TipoCuenta> obtenerTipoCuentas();
	public boolean modificar(TipoCuenta tipoCuenta);
	public TipoCuenta verificarTransaccion(int codTipoCuenta);
	
}
