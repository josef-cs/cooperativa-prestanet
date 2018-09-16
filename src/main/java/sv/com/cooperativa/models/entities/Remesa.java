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
@Table(name="remesas")
public class Remesa {
@Id
private Long id_remesa;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date fecha_deposito;
@NotNull
@NotEmpty
private double monto;
@NotNull
@NotEmpty
private String estado;

public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Prestamo getPrestamo() {
	return prestamo;
}
public void setPrestamo(Prestamo prestamo) {
	this.prestamo = prestamo;
}
public Banco getBanco() {
	return banco;
}
public void setBanco(Banco banco) {
	this.banco = banco;
}
@JoinColumn(name="cliente_dui")
@OneToOne(fetch=FetchType.LAZY)
private Cliente cliente;
@JoinColumn(name="prestamo_id")
@OneToOne(fetch=FetchType.LAZY)
private Prestamo prestamo;
@JoinColumn(name="banco_id")
@OneToOne(fetch=FetchType.LAZY)
private Banco banco;

public Long getId_remesa() {
	return id_remesa;
}
public void setId_remesa(Long id_remesa) {
	this.id_remesa = id_remesa;
}
public Date getFecha_deposito() {
	return fecha_deposito;
}
public void setFecha_deposito(Date fecha_deposito) {
	this.fecha_deposito = fecha_deposito;
}
public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
}
