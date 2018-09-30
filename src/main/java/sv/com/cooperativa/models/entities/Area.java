package sv.com.cooperativa.models.entities;
import java.sql.Date;
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
import javax.persistence.SequenceGenerator;
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
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "area_seq")
@SequenceGenerator(name = "area_seq", sequenceName = "area_seq", allocationSize=1)
private Integer id_area;

@NotNull
@NotEmpty
private String nombre;
@NotNull
@NotEmpty
private String descripcion;

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="area_id")
private List<Cargo> cargos;

public List<Cargo> getCargos() {
	return cargos;
}
public void setCargos(List<Cargo> cargos) {
	this.cargos = cargos;
}
public Integer getId_area() {
	return id_area;
}
public void setId_area(Integer id_area) {
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
