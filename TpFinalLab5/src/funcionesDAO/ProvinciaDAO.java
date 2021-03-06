package funcionesDAO;

import java.util.List;
import entidad.Provincia;

public interface ProvinciaDAO {

	public boolean insertarProvincia(Provincia provincia);
	public Provincia obtenerProvincia(int id);
	public boolean buscarProvincia(int id);
	public List<Provincia> obtenerProvincias();
	public boolean modificar(Provincia provincia);
	public void Finalizar();
	public void Inicializar();
}
