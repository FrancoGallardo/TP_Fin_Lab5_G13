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
	
	
	
}
