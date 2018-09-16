package sv.com.cooperativa.models.entities;
import java.sql.Date;

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
@Table(name="areas")
public class Area {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@NotNull
@NotEmpty
private Long id_area;
@NotNull
@NotEmpty
private String nombre;
@NotNull
@NotEmpty
private String descripcion;
public Long getId_area() {
	return id_area;
}
public void setId_area(Long id_area) {
	this.id_area = id_area;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
}
