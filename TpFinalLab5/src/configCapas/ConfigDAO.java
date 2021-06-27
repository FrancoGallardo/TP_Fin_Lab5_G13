package configCapas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import funcionesDAOImp.Conexion;

@Configuration
public class ConfigDAO {
	
	@Bean
	public Conexion ConexionBD() {
		Conexion conn = new Conexion();
		return conn;
	}
	
}
