package funcionesDAO;

import java.util.List;
import entidad.Localidad;

public interface LocalidadDAO{

	public boolean insertarLocalidad(Localidad localidad);
	public Localidad obtenerLocalidad(int id);
	public boolean buscarLocalidad(int id);
	public List<Localidad> obtenerLocalidades();
	public boolean modificar(Localidad localidad);
	public void Finalizar();
	public void Inicializar();
}
