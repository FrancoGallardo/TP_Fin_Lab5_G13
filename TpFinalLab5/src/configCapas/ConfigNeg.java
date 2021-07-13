package configCapas;

import org.springframework.context.annotation.Bean;

import negocioImp.ClienteNImp;
import negocioImp.TipoCuentaNImp;
import negocioImp.CuentaNImp;
import negocioImp.LocalidadNImp;
import negocioImp.ProvinciaNImp;
import negocioImp.TransaccionNImp;
import negocioImp.UsuarioNImp;

public class ConfigNeg {

	@Bean
	public ClienteNImp clienteNImp() {
		ClienteNImp clienteNImp = new ClienteNImp();
		return clienteNImp;
	}
	
	@Bean
	public TipoCuentaNImp tipoCuentaNImp() {
		TipoCuentaNImp tipoCuentaNImp = new TipoCuentaNImp();
		return tipoCuentaNImp;
	}
	
	@Bean
	public CuentaNImp cuentaNImp() {
		CuentaNImp cuentaNImp = new CuentaNImp();
		return cuentaNImp;
	}
	
	@Bean
	public LocalidadNImp localidadNImp() {
		LocalidadNImp localidadNImp = new LocalidadNImp();
		return localidadNImp;
	}
	
	@Bean
	public ProvinciaNImp provinciaNImp() {
		ProvinciaNImp provinciaNImp = new ProvinciaNImp();
		return provinciaNImp;
	}
	
	@Bean
	public TransaccionNImp transaccionNImp() {
		TransaccionNImp transaccionNImp = new TransaccionNImp();
		return transaccionNImp;
	}
	
	@Bean
	public UsuarioNImp usuarioNImp() {
		UsuarioNImp usuarioNImp = new UsuarioNImp();
		return usuarioNImp;
	}
	
	
}
