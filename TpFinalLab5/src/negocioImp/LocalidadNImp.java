package negocioImp;

import java.util.List;

import entidad.Localidad;
import funcionesDAOImp.LocalidadDAOImp;
import negocio.LocalidadN;

public class LocalidadNImp implements LocalidadN{

	LocalidadDAOImp locDAO = new LocalidadDAOImp();
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Localidad loc) {
		// TODO Auto-generated method stub
		return false;
	}

}
