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
@Table(name="prestamos")
public class Prestamo {
@Id
private Long id_prestamo;
@NotNull
@NotEmpty
private double monto;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date fecha_limite;
@NotNull
@NotEmpty
private String estado;
@NotNull
@NotEmpty
private double saldo;

/*FORANEAS*/
@JoinColumn(name="empleado_autoriza_dui", insertable = false, updatable = false)
@OneToOne(fetch=FetchType.LAZY)
private Empleado empleado;
@JoinColumn(name="solicitud_id")
@OneToOne(fetch=FetchType.LAZY)
private Solicitud solicitud;
public Empleado getEmpleado() {
	return empleado;
}
public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}
public Solicitud getSolicitud() {
	return solicitud;
}
public void setSolicitud(Solicitud solicitud) {
	this.solicitud = solicitud;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public TasaInteres getTasainteres() {
	return tasainteres;
}
public void setTasainteres(TasaInteres tasainteres) {
	this.tasainteres = tasainteres;
}
@JoinColumn(name="cliente_dui")
@OneToOne(fetch=FetchType.LAZY)
private Cliente cliente;
@JoinColumn(name="tasa_interes_id")
@OneToOne(fetch=FetchType.LAZY)
private TasaInteres tasainteres;

public Long getId_prestamo() {
	return id_prestamo;
}
public void setId_prestamo(Long id_prestamo) {
	this.id_prestamo = id_prestamo;
}

public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}

public Date getFecha_limite() {
	return fecha_limite;
}
public void setFecha_limite(Date fecha_limite) {
	this.fecha_limite = fecha_limite;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public double getSaldo() {
	return saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}
}
