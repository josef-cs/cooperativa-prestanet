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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="solicitudes")
public class Solicitud {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sol_seq")
@SequenceGenerator(name = "sol_seq", sequenceName = "sol_seq", allocationSize=1)
private Long id_solicitud;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd/MM/yyyy")
private Date fecha;

@NotNull
private Double monto;

@NotNull
private String estado;

@JoinColumn(name="cliente_dui")
@OneToOne(fetch=FetchType.LAZY)
private Cliente cliente;

@JoinColumn(name="empleado_dui")
@OneToOne(fetch=FetchType.LAZY)
private Empleado empleado;

public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Empleado getEmpleado() {
	return empleado;
}
public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}


public Long getId_solicitud() {
	return id_solicitud;
}
public void setId_solicitud(Long id_solicitud) {
	this.id_solicitud = id_solicitud;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public Double getMonto() {
	return monto;
}
public void setMonto(Double monto) {
	this.monto = monto;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
}
