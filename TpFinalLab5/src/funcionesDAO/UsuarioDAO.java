package funcionesDAO;

import java.util.List;
import entidad.Usuario;

public interface UsuarioDAO {

	public boolean insertarUsuario(Usuario user);
	public Usuario obtenerUsuario(String Username);
	public boolean buscarUsuario(int id);
	public List<Usuario> obtenerUsuarios();
	public boolean modificar(Usuario usuario);
	public Usuario verificarUsuario(String Username);
	public void Finalizar();
	public void Inicializar();
	
}
