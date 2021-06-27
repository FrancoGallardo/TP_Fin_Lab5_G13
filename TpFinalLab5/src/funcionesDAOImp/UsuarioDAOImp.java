package funcionesDAOImp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entidad.Usuario;
import funcionesDAO.UsuarioDAO;
import configCapas.ConfigDAO;

public class UsuarioDAOImp implements UsuarioDAO{
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;

	
	@Override
	public boolean insertarUsuario(Usuario user) {
		Inicializar();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		Finalizar();
		return true;
	}

	@Override
	public Usuario obtenerUsuario(String Username) {
		Inicializar();
		Usuario user;
		try {
			session.beginTransaction();
			user=(Usuario) session.get(Usuario.class, Username);
		}
		catch(Exception e) {
			user=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return user;
	}

	@Override
	public boolean buscarUsuario(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		Inicializar();
		List<Usuario> lstUsers;
		try {
		query=session.createQuery("FROM Usuario");
		lstUsers=query.list();
		}
		catch(Exception e){
			lstUsers=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstUsers;
	}

	@Override
	public boolean modificar(Usuario usuario) {
		Boolean res=false;
		Inicializar();
		try {
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
			res=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			res=false;
		}
		finally {
			Finalizar();
		}
		return res;
	}

	@Override
	public Usuario verificarUsuario(String Username) {
		Conexion con = new Conexion();
		Session session = con.abrirConexion();
		session.beginTransaction();
		Usuario user = (Usuario)session.get(Usuario.class, Username);
		con.cerrarSession();
		return user;
	}
	
	@Override
	public void Finalizar() {
		con.cerrarSession();
		((ConfigurableApplicationContext)(appContext)).close();
	}

	@Override
	public void Inicializar() {
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		con = (Conexion) appContext.getBean("ConexionBD");
		session=con.abrirConexion();
	}

}
