package negocioImp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Localidad;
import funcionesDAOImp.CuentaDAOImp;
import funcionesDAOImp.LocalidadDAOImp;
import negocio.LocalidadN;

public class LocalidadNImp implements LocalidadN{

	LocalidadDAOImp locDAO;
	private ApplicationContext appContext;
	
	public LocalidadNImp() {
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		locDAO = (LocalidadDAOImp) appContext.getBean("LocalidadDAO");
	}
	
	@Override
	public Localidad verificarLocalidad(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertarLocalidad(Localidad loc) {
		return locDAO.insertarLocalidad(loc);
	}

	@Override
	public boolean buscarLocalidad(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		return locDAO.obtenerLocalidades();
	}

	@Override
	public boolean modificar(Localidad loc) {
		// TODO Auto-generated method stub
		return false;
	}

}
