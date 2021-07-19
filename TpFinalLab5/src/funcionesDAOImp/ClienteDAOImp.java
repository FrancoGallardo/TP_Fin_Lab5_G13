package funcionesDAOImp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Cliente;
import entidad.Usuario;
import funcionesDAO.ClienteDAO;

public class ClienteDAOImp implements ClienteDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
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
	
	@Override
	public boolean insertarCliente(Cliente cli) {
		Inicializar();
		session.beginTransaction();
		session.save(cli);
		session.getTransaction().commit();
		Finalizar();
		return true;
	}

	@Override
	public Cliente obtenerCliente(int DNI) {
		Inicializar();
		Cliente cli;
		try {
			session.beginTransaction();
			cli = (Cliente) session.get(Cliente.class, DNI);
		}
		catch(Exception e) {
			cli=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return cli;
	}

	@Override
	public boolean buscarCliente(int DNI) {
		return true;
	}

	@Override
	public List<Cliente> obtenerClientes() {
		Inicializar();
		List<Cliente> lstClientes;
		try {
		query=session.createQuery("FROM Cliente");
		lstClientes=query.list();
		}
		catch(Exception e){
			lstClientes=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstClientes;
	}

	@Override
	public boolean modificar(Cliente cli) {
		Boolean res=false;
		Inicializar();
		
		try {
			session.beginTransaction();
			session.update(cli);
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
	public Cliente verificarCliente(int DNI) {
		Inicializar();
		Cliente cli = (Cliente)session.get(Cliente.class, DNI);
		Finalizar();
		return cli;
	}

	@Override
	public List<Cliente> obtenerClientexUsuario(String Usuario) {
		Inicializar();
		List<Cliente> lstClientes;
		try {
			query=session.createQuery("FROM Cliente WHERE Username = '" + Usuario + "'");
			lstClientes=query.list();
		}
		catch(Exception e) {
			lstClientes=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstClientes;
	}
}
