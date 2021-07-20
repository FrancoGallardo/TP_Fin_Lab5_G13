package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Username")
	private String Username;
	@Column(name="Password")
	private String Password;
	@Column(name="TipoUsuario")
	private String TipoUsuario;
	@Column(name="Estado")
	private Boolean Estado;
	
	
	public Usuario(String username, String password, String tipoUsuario, Boolean estado) {
		Username = username;
		Password = password;
		TipoUsuario = tipoUsuario;
		Estado = estado;
	}
	
	public Usuario() {
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public String getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	

	@Override
	public String toString() {
		return "Usuario [Username=" + Username + ", Password=" + Password + ", TipoUsuario=" + TipoUsuario + ", Estado="
				+ Estado + "]";
	}

	public boolean equals(Usuario user) {
		if (this.Username.equals(user.getUsername())) {
			return true;
		}
		else{
			return false;
		}
	}
	
}
