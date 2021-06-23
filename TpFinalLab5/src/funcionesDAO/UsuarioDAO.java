package funcionesDAO;

import java.util.List;
import entidad.Usuario;

public interface UsuarioDAO {

	public boolean insertarUsuario(Usuario user);
	public Usuario obtenerUsuario(int id);
	public boolean buscarUsuario(int id);
	public List<Usuario> obtenerUsuarios();
	public boolean modificar(Usuario usuario);
	
}
