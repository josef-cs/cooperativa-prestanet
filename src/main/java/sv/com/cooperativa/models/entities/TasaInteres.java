package sv.com.cooperativa.models.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tasa_seq")
@SequenceGenerator(name = "tasa_seq", sequenceName = "tasa_seq", allocationSize=1)
private Integer id_tasa_interes;
@NotNull
private Double tasa;
@NotEmpty
@NotNull
private String estado;

public Integer getId_tasa_interes() {
	return id_tasa_interes;
}
public void setId_tasa_interes(Integer id_tasa_interes) {
	this.id_tasa_interes = id_tasa_interes;
}
public Double getTasa() {
	return tasa;
}
public void setTasa(Double tasa) {
	this.tasa = tasa;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}

}
