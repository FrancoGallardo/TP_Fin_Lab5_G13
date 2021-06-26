package negocioImp;
import entidad.Usuario;
import negocio.UsuarioN;
import funcionesDAOImp.UsuarioDAOImp;


public class UsuarioNImp implements UsuarioN{

	UsuarioDAOImp userDAO = new UsuarioDAOImp();
	
	@Override
	public Usuario verificarUsuario(String Username, String Password) {
		try {
			Usuario user = new Usuario();
			user = userDAO.verificarUsuario(Username);
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public boolean insertarAdministrador(Usuario user) {
		user.setUsername("admin");
		user.setPassword("admin");
		user.setTipoUsuario("administrador");
		user.setEstado(true);
		return userDAO.insertarUsuario(user);
	}

	@Override
	public boolean insertarUsuario(Usuario user) {
		return userDAO.insertarUsuario(user);
	}
	
	
	
}
