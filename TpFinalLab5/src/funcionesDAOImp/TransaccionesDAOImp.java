package funcionesDAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Transaccion;
import funcionesDAO.TransaccionDAO;

public class TransaccionesDAOImp implements TransaccionDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@Override
	public boolean insertarTransaccion(Transaccion transaccion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transaccion obtenerTransaccion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscarTransaccion(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transaccion> obtenerTransaccion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Transaccion transaccion) {
		// TODO Auto-generated method stub
		return false;
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
