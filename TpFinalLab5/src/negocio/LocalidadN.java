package negocio;

import java.util.List;

import entidad.Localidad;

public interface LocalidadN {
	public Localidad verificarLocalidad(int id);
	public boolean insertarLocalidad(Localidad loc);
	public boolean buscarLocalidad(int id);
	public List<Localidad> obtenerLocalidades();
	public boolean modificar(Localidad loc);
}
