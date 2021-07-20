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
@Table(name="Cuenta")
public class Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CBU")
	private int CBU;
	@Column(name="DNI")
	private int DNI;
	@Column(name="Fecha_Creacion")
	@Type(type="date")
	private Date Fecha_Creacion;
	@Column(name="CodTipoCuenta")
	private int CodTipoCuenta;
	@Column(name = "NumeroCuenta")
	private int NumeroCuenta;
	@Column(name="Saldo")
	private Double Saldo;
	@Column(name="Estado")
	private Boolean Estado;
	
	
	public Cuenta(int cbu, Date fecha, int codTipoCuenta, int numeroCuenta, Double saldo, Boolean estado) {
		CBU = cbu;
		Fecha_Creacion = fecha;
		CodTipoCuenta = codTipoCuenta;
		NumeroCuenta = numeroCuenta;
		Saldo = saldo;
		Estado = estado;
	}

	public Cuenta() {
	}

	public int getCBU() {
		return CBU;
	}

	public void setCBU(int cBU) {
		CBU = cBU;
	}

	public int getCodTipoCuenta() {
		return CodTipoCuenta;
	}

	public void setCodTipoCuenta(int codTipoCuenta) {
		CodTipoCuenta = codTipoCuenta;
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public Double getSaldo() {
		return Saldo;
	}

	public void setSaldo(Double saldo) {
		Saldo = saldo;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dni) {
		DNI = dni;
	}

	public Date getFecha_Creacion() {
		return Fecha_Creacion;
	}

	public void setFecha_Creacion(Date fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}

	@Override
	public String toString() {
		return "Cuenta [CBU=" + CBU + ", DNI=" + DNI + ", Fecha_Creacion=" + Fecha_Creacion + ", CodTipoCuenta="
				+ CodTipoCuenta + ", NumeroCuenta=" + NumeroCuenta + ", Saldo=" + Saldo + ", Estado=" + Estado + "]";
	}

	
}
