package negocio;

import entidad.Usuario;

public interface UsuarioN {
	public Usuario verificarUsuario(String Username , String Password);
	public boolean insertarAdministrador(Usuario user);
	public boolean insertarUsuario(Usuario user);
}
