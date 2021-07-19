package funcionesDAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Cuenta;
import entidad.Usuario;
import funcionesDAO.CuentaDAO;

public class CuentaDAOImp implements CuentaDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@Override
	public boolean insertarCuenta(Cuenta cuenta) {
		Inicializar();
		session.beginTransaction();
		session.save(cuenta);
		session.getTransaction().commit();
		Finalizar();
		return true;
	}

	@Override
	public Cuenta obtenerCuenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		Inicializar();
		List<Cuenta> lstCuenta;
		try {
		query=session.createQuery("FROM Cuenta");
		lstCuenta=query.list();
		}
		catch(Exception e){
			lstCuenta=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstCuenta;
	}
	
	@Override
	public boolean verificarCuenta(int cbu) {
		Inicializar();
		Cuenta cuenta = (Cuenta)session.get(Cuenta.class, cbu);
		Finalizar();
		if(cuenta != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modificar(Cuenta cuenta) {
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
