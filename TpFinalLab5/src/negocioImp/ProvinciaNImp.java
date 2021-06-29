package negocioImp;

import java.util.List;

import entidad.Provincia;
import negocio.ProvinciaN;
import funcionesDAOImp.ProvinciaDAOImp;

public class ProvinciaNImp implements ProvinciaN{

	ProvinciaDAOImp provDAO = new ProvinciaDAOImp();
	
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
