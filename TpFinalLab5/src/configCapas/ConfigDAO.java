package configCapas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import funcionesDAOImp.ClienteDAOImp;
import funcionesDAOImp.Conexion;
import funcionesDAOImp.CuentaDAOImp;
import funcionesDAOImp.LocalidadDAOImp;
import funcionesDAOImp.ProvinciaDAOImp;
import funcionesDAOImp.TipoCuentaDAOImp;
import funcionesDAOImp.TransaccionesDAOImp;
import funcionesDAOImp.UsuarioDAOImp;

@Configuration
public class ConfigDAO {
	
	@Bean
	public Conexion ConexionBD() {
		Conexion conn = new Conexion();
		return conn;
	}
	
	@Bean
	public ClienteDAOImp ClienteDAO() {
		ClienteDAOImp clienteDAO = new ClienteDAOImp();
		return clienteDAO;
	}
	
	@Bean
	public CuentaDAOImp CuentaDAO() {
		CuentaDAOImp CuentaDAO = new CuentaDAOImp();
		return CuentaDAO;
	}
	
	@Bean
	public LocalidadDAOImp LocalidadDAO() {
		LocalidadDAOImp localidadDAO = new LocalidadDAOImp();
		return localidadDAO;
	}
	
	@Bean
	public ProvinciaDAOImp ProvinciaDAO() {
		ProvinciaDAOImp provinciaDAO = new ProvinciaDAOImp();
		return provinciaDAO;
	}
	
	@Bean
	public TipoCuentaDAOImp TipoCuentaDAO() {
		TipoCuentaDAOImp tipoCuentaDAO = new TipoCuentaDAOImp();
		return tipoCuentaDAO;
	}
	
	@Bean
	public TransaccionesDAOImp TransaccionDAO() {
		TransaccionesDAOImp transaccionDAO = new TransaccionesDAOImp();
		return transaccionDAO;
	}
	
	@Bean
	public UsuarioDAOImp UsuarioDAO() {
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp();
		return usuarioDAO;
	}

	
}
