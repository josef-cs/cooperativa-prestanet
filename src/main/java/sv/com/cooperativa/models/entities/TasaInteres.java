package sv.com.cooperativa.models.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tasa_interes")
public class TasaInteres {
@Id
private Long id_tasa_interes;
@NotEmpty
@NotNull
private double tasa;
@NotEmpty
@NotNull
private String estado;

public Long getId_tasa_interes() {
	return id_tasa_interes;
}
public void setId_tasa_interes(Long id_tasa_interes) {
	this.id_tasa_interes = id_tasa_interes;
}
public double getTasa() {
	return tasa;
}
public void setTasa(double tasa) {
	this.tasa = tasa;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}

}
