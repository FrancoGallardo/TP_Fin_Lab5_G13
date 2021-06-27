package funcionesDAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Cuenta;
import funcionesDAO.CuentaDAO;

public class CuentaDAOImp implements CuentaDAO{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@Override
	public boolean insertarCuenta(Cuenta user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta obtenerCuenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscarCuenta(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		// TODO Auto-generated method stub
		return null;
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
