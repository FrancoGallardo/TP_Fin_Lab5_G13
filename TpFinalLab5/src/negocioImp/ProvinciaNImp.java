package negocioImp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Provincia;
import negocio.ProvinciaN;
import funcionesDAOImp.LocalidadDAOImp;
import funcionesDAOImp.ProvinciaDAOImp;

public class ProvinciaNImp implements ProvinciaN{

	ProvinciaDAOImp provDAO = new ProvinciaDAOImp();
	private ApplicationContext appContext;
	
	public ProvinciaNImp() {
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		provDAO = (ProvinciaDAOImp) appContext.getBean("ProvinciaDAO");
	}
	
	@Override
	public Provincia verificarProvincia(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertarProvincia(Provincia prov) {
		return provDAO.insertarProvincia(prov);
	}

	@Override
	public boolean buscarProvincia(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Provincia> obtenerProvincias() {
		return provDAO.obtenerProvincias();
	}

	@Override
	public boolean modificar(Provincia usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
