package funcionesDAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.TipoCuenta;
import entidad.Usuario;
import funcionesDAO.TipoCuentaDAO;

public class TipoCunetaDAOImp implements TipoCuentaDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@Override
	public boolean insertarTipoCuenta(TipoCuenta tipoCuenta) {
		Inicializar();
		session.beginTransaction();
		session.save(tipoCuenta);
		session.getTransaction().commit();
		Finalizar();
		return true;
	}

	@Override
	public TipoCuenta obtenerTipoCuenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscarTipoCuenta(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TipoCuenta> obtenerTipoCuenta() {
		Inicializar();
		List<TipoCuenta> lstTipoCuenta;
		try {
		query=session.createQuery("FROM TipoCuenta");
		lstTipoCuenta=query.list();
		}
		catch(Exception e){
			lstTipoCuenta=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstTipoCuenta;
	}

	@Override
	public boolean modificar(TipoCuenta tipoCuenta) {
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
