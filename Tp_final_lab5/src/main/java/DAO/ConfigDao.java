package DAO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import FuncionesDAOImpl.Conexion;

@Configuration
public class ConfigDao {
	@Bean
	public Conexion ConexionBD() {
		Conexion conn = new Conexion();
		return conn;
	}
}

