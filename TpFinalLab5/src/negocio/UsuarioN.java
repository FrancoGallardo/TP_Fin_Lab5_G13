package negocio;

import java.util.List;

import entidad.Usuario;

public interface UsuarioN {
	public boolean insertarAdministrador(Usuario user);
	public boolean insertarUsuario(Usuario user);
	public List<Usuario> obtenerUsuarios();
	public boolean modificar(Usuario cli);
	public Usuario verificarUsuario(String Username);
}
