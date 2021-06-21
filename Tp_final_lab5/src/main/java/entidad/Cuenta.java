package entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	public Date getFecha() {
		return Fecha_Creacion;
	}

	public void setFecha(Date fecha) {
		Fecha_Creacion = fecha;
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

	@Override
	public String toString() {
		return "Cuenta [CBU=" + CBU + ", Fecha_Creacion=" + Fecha_Creacion + ", CodTipoCuenta=" + CodTipoCuenta
				+ ", NumeroCuenta=" + NumeroCuenta + ", Saldo=" + Saldo + ", Estado=" + Estado
				+ "]";
	}
	
}
