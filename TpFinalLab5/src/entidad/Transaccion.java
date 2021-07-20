package entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Transaccion")
public class Transaccion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idTransaccion")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransaccion;
	@Column(name="CBU_Egreso")
	private int CBU_Egreso;
	@Column(name="CBU_Ingresa")
	private int CBU_Ingresa;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name="Monto")
	private Double Monto;
	@Column(name="fecha")
	@Type(type="date")
	private Date fecha;
	@Column(name="Estado")
	private Boolean Estado;
	
	public Transaccion() {
		Estado = true;
	}
	
	public Transaccion(int idTransaccion, int cBU_Egreso, int cBU_Ingresa, String descripcion, Double monto, Date fecha,
			Boolean estado) {
		super();
		this.idTransaccion = idTransaccion;
		CBU_Egreso = cBU_Egreso;
		CBU_Ingresa = cBU_Ingresa;
		this.descripcion = descripcion;
		Monto = monto;
		this.fecha = fecha;
		Estado = estado;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public int getCBU_Egreso() {
		return CBU_Egreso;
	}
	public void setCBU_Egreso(int cBU_Egreso) {
		CBU_Egreso = cBU_Egreso;
	}
	public int getCBU_Ingresa() {
		return CBU_Ingresa;
	}
	public void setCBU_Ingresa(int cBU_Ingresa) {
		CBU_Ingresa = cBU_Ingresa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getMonto() {
		return Monto;
	}
	public void setMonto(Double monto) {
		Monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Transaccion [idTransaccion=" + idTransaccion + ", CBU_Egreso=" + CBU_Egreso + ", CBU_Ingresa="
				+ CBU_Ingresa + ", descripcion=" + descripcion + ", Monto=" + Monto + ", fecha=" + fecha + ", Estado="
				+ Estado + "]";
	}

	
}
