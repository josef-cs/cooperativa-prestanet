package sv.com.cooperativa.models.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pre_seq")
	@SequenceGenerator(name = "pre_seq", sequenceName = "pre_seq", allocationSize=1)
private Long id_prestamo;
@NotNull
private Double monto;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd/MM/yyyy")
private Date fecha_limite;
@NotNull
private String estado;
@NotNull
private Double saldo;

/*FORANEAS*/
@JoinColumn(name="empleado_autoriza_dui")
@OneToOne(fetch=FetchType.LAZY)
private Empleado empleado;

@JoinColumn(name="solicitud_id")
@OneToOne(fetch=FetchType.LAZY)
private Solicitud solicitud;

@JoinColumn(name="cliente_dui")
@OneToOne(fetch=FetchType.LAZY)
private Cliente cliente;

@JoinColumn(name="tasa_interes_id")
@OneToOne(fetch=FetchType.LAZY)
private TasaInteres tasainteres;

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="prestamo_id")
private List<Pago> pagos;

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="prestamo_id")
private List<Cuota> cuotas;

public List<Cuota> getCuotas() {
	return cuotas;
}
public void setCuotas(List<Cuota> cuotas) {
	this.cuotas = cuotas;
}
public List<Pago> getPagos() {
	return pagos;
}
public void setPagos(List<Pago> pagos) {
	this.pagos = pagos;
}
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

public Long getId_prestamo() {
	return id_prestamo;
}
public void setId_prestamo(Long id_prestamo) {
	this.id_prestamo = id_prestamo;
}

public Double getMonto() {
	return monto;
}
public void setMonto(Double monto) {
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
public Double getSaldo() {
	return saldo;
}
public void setSaldo(Double saldo) {
	this.saldo = saldo;
}
}
