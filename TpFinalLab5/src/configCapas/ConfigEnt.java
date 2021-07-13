package configCapas;

import org.springframework.context.annotation.Bean;

import entidad.Usuario;
import entidad.Cuenta;
import entidad.Localidad;
import entidad.TipoCuenta;
import entidad.Transaccion;
import entidad.Provincia;
import entidad.Cliente;

public class ConfigEnt {

	@Bean
	public Usuario usuario() {
		Usuario usuario = new Usuario();
		return usuario;
	}
	
	@Bean
	public Cuenta cuenta() {
		Cuenta cuenta = new Cuenta();
		return cuenta;
	}
	
	@Bean
	public Localidad localidad() {
		Localidad localidad = new Localidad();
		return localidad;
	}
	
	@Bean
	public TipoCuenta tipoCuenta() {
		TipoCuenta tipoCuenta = new TipoCuenta();
		return tipoCuenta;
	}
	
	@Bean
	public Transaccion transaccion() {
		Transaccion transaccion = new Transaccion();
		return transaccion;
	}
	
	@Bean
	public Provincia provincia() {
		Provincia provincia = new Provincia();
		return provincia;
	}
	
	@Bean
	public Cliente cliente() {
		Cliente cliente = new Cliente();
		return cliente;
	}
	
}
