package negocio;

import java.util.List;

import entidad.Usuario;

public interface UsuarioN {
	public boolean insertarAdministrador(Usuario user);
	public boolean insertarUsuario(Usuario user);
	public List<Usuario> obtenerUsuarios();
	public boolean modificar(Usuario user);
	public Usuario verificarUsuario(String Username);
}
