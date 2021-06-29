package funcionesDAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Localidad;
import entidad.Provincia;
import funcionesDAO.LocalidadDAO;

public class LocalidadDAOImp implements LocalidadDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@Override
	public boolean insertarLocalidad(Localidad localidad) {
		Inicializar();
		session.beginTransaction();
		session.save(localidad);
		session.getTransaction().commit();
		Finalizar();
		return true;
	}

	@Override
	public Localidad obtenerLocalidad(int id) {
		Inicializar();
		Localidad loc;
		try {
			session.beginTransaction();
			loc=(Localidad) session.get(Localidad.class, id);
		}
		catch(Exception e) {
			loc=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return loc;
	}

	@Override
	public boolean buscarLocalidad(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		Inicializar();
		List<Localidad> lstLoc;
		try {
		query=session.createQuery("FROM Localidad");
		lstLoc=query.list();
		}
		catch(Exception e){
			lstLoc=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstLoc;
	}

	@Override
	public boolean modificar(Localidad localidad) {
		Boolean res=false;
		Inicializar();
		try {
			session.beginTransaction();
			session.update(localidad);
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
