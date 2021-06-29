package funcionesDAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Provincia;
import funcionesDAO.ProvinciaDAO;

public class ProvinciaDAOImp implements ProvinciaDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@Override
	public boolean insertarProvincia(Provincia provincia) {
		Inicializar();
		session.beginTransaction();
		session.save(provincia);
		session.getTransaction().commit();
		Finalizar();
		return true;
	}

	@Override
	public Provincia obtenerProvincia(int id) {
		Inicializar();
		Provincia prov;
		try {
			session.beginTransaction();
			prov=(Provincia) session.get(Provincia.class, id);
		}
		catch(Exception e) {
			prov=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return prov;
	}

	@Override
	public boolean buscarProvincia(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Provincia> obtenerProvincias() {
		Inicializar();
		List<Provincia> lstProv;
		try {
		query=session.createQuery("FROM Provincia");
		lstProv=query.list();
		}
		catch(Exception e){
			lstProv=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstProv;
	}

	@Override
	public boolean modificar(Provincia provincia) {
		Boolean res=false;
		Inicializar();
		try {
			session.beginTransaction();
			session.update(provincia);
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
