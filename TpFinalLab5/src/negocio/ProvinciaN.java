package negocio;

import java.util.List;

import entidad.Provincia;

public interface ProvinciaN {
	public Provincia verificarProvincia(int id);
	public boolean insertarProvincia(Provincia cli);
	public boolean buscarProvincia(int id);
	public List<Provincia> obtenerProvincias();
	public boolean modificar(Provincia usuario);
}
