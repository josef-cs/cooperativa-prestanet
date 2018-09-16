package sv.com.cooperativa.models.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pagos")
public class Pago {
@Id
private Long id_pago;
@NotNull
@NotEmpty
private double monto;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date fecha_pago;
@NotNull
@NotEmpty
private String estado;

/*FORANEAS*/
@JoinColumn(name="prestamo_id")
@OneToOne(fetch=FetchType.LAZY)
private Prestamo prestamo;
@JoinColumn(name="empleado_dui")
@OneToOne(fetch=FetchType.LAZY)
private Empleado empleado;
@JoinColumn(name="cuota_id")
@OneToOne(fetch=FetchType.LAZY)
private Cuota cuota;

public Prestamo getPrestamo() {
	return prestamo;
}
public void setPrestamo(Prestamo prestamo) {
	this.prestamo = prestamo;
}
public Empleado getEmpleado() {
	return empleado;
}
public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}
public Cuota getCuota() {
	return cuota;
}
public void setCuota(Cuota cuota) {
	this.cuota = cuota;
}

public Long getId_pago() {
	return id_pago;
}
public void setId_pago(Long id_pago) {
	this.id_pago = id_pago;
}

public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}
public Date getFecha_pago() {
	return fecha_pago;
}
public void setFecha_pago(Date fecha_pago) {
	this.fecha_pago = fecha_pago;
}

public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
}
