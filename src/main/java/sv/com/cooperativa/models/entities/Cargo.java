package sv.com.cooperativa.models.entities;
import java.sql.Date;

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

@Entity
@Table(name="cargos")
public class Cargo
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cargo_seq")
@SequenceGenerator(name = "cargo_seq", sequenceName = "cargo_seq", allocationSize=1)
private Integer id_cargo;
@NotNull
@NotEmpty
private String titulo;
@NotNull
@NotEmpty
private String descripcion;
@NotNull
private Double sueldo_base;
@JoinColumn(name="area_id")
@OneToOne(fetch=FetchType.LAZY)
private Area area;

public Integer getId_cargo() {
	return id_cargo;
}
public void setId_cargo(Integer id_cargo) {
	this.id_cargo = id_cargo;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Double getSueldo_base() {
	return sueldo_base;
}
public void setSueldo_base(Double sueldo_base) {
	this.sueldo_base = sueldo_base;
}

public Area getArea() {
	return area;
}
public void setArea(Area area) {
	this.area = area;
}
}
