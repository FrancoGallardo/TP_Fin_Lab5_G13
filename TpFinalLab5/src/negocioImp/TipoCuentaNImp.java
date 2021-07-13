package negocioImp;

import java.util.List;

import entidad.TipoCuenta;
import negocio.TipoCuentaN;
import funcionesDAOImp.TipoCuentaDAOImp;

public class TipoCuentaNImp implements TipoCuentaN{

	TipoCuentaDAOImp tipoCuentaDAO = new TipoCuentaDAOImp();
	
	@Override
	public boolean insertarTipoCuenta(TipoCuenta tipoCuenta) {
		return tipoCuentaDAO.insertarTipoCuenta(tipoCuenta);
	}

	@Override
	public boolean buscarTipoCuenta(int codTipoCuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TipoCuenta> obtenerTipoCuentas() {
		return tipoCuentaDAO.obtenerTipoCuenta();
	}

	@Override
	public boolean modificar(TipoCuenta tipoCuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TipoCuenta verificarTransaccion(int codTipoCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}
