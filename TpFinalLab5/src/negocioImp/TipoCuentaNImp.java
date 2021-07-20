package negocioImp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.TipoCuenta;
import negocio.TipoCuentaN;
import funcionesDAOImp.ProvinciaDAOImp;
import funcionesDAOImp.TipoCuentaDAOImp;

public class TipoCuentaNImp implements TipoCuentaN{

	TipoCuentaDAOImp tipoCuentaDAO;
	private ApplicationContext appContext;
	
	public TipoCuentaNImp(){
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		tipoCuentaDAO = (TipoCuentaDAOImp) appContext.getBean("TipoCuentaDAO");
	}
	
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
