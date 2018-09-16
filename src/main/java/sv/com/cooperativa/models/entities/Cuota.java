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
@Table(name="cuotas")
public class Cuota {
@Id
private Long id_cuota;
@JoinColumn(name="prestamo_id")
@OneToOne(fetch=FetchType.LAZY)
private Prestamo prestamo;
@NotNull
@NotEmpty
private Long numero_cuota;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date fecha_limite;
@NotNull
@NotEmpty
private String estado;

public Long getId_cuota() {
	return id_cuota;
}
public void setId_cuota(Long id_cuota) {
	this.id_cuota = id_cuota;
}
public Long getNumero_cuota() {
	return numero_cuota;
}
public void setNumero_cuota(Long numero_cuota) {
	this.numero_cuota = numero_cuota;
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
public Prestamo getPrestamo() {
	return prestamo;
}
public void setPrestamo(Prestamo prestamo) {
	this.prestamo = prestamo;
}

}
