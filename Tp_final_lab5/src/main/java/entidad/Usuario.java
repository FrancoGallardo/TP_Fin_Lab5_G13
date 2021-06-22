package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdUsuario")
	private int IdUsuario;
	@Column(name="Username")
	private String Username;
	@Column(name="Password")
	private String Password;
	@Column(name="Estado")
	private Boolean Estado;
	
	
	public Usuario(String username, String password, int idUsuario, Boolean estado) {
		Username = username;
		Password = password;
		IdUsuario = idUsuario;
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
	
	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}


	
	@Override
	public String toString() {
		return "Usuario [IdUsuario=" + IdUsuario + ", Username=" + Username + ", Password=" + Password + ", Estado="
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
