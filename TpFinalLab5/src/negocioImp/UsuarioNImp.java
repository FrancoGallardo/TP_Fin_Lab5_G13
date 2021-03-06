package negocioImp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Usuario;
import negocio.UsuarioN;
import funcionesDAOImp.UsuarioDAOImp;


public class UsuarioNImp implements UsuarioN{

	UsuarioDAOImp userDAO;
	private ApplicationContext appContext;
	
	public UsuarioNImp(){
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		userDAO = (UsuarioDAOImp) appContext.getBean("UsuarioDAO");
	}
	
	@Override
	public Usuario verificarUsuario(String Username) {
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

	@Override
	public List<Usuario> obtenerUsuarios() {
		return userDAO.obtenerUsuarios();
	}

	@Override
	public boolean modificar(Usuario user) {
		return userDAO.modificar(user);
	}
	
	
	
}
