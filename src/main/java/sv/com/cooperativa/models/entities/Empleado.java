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
@Table(name="empleados")
public class Empleado {

@Id
private String dui_empleado;
@NotEmpty
private String nombres;
@NotEmpty
private String apellidos;
@NotEmpty
private String direccion;
@NotEmpty
private String nit;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date fecha_nacimiento;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
@NotNull
private Date fecha_ingreso;
@NotEmpty
private String telefono;
@NotEmpty
private String celular;
@Email
private String correo;
@NotEmpty
@NotNull
private String estado;
@JoinColumn(name="cargo_id")
@OneToOne(fetch=FetchType.LAZY)
private Cargo cargo;
public Empleado()
{}

public String getDui_empleado() {
	return dui_empleado;
}

public void setDui_empleado(String dui_empleado) {
	this.dui_empleado = dui_empleado;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getNit() {
	return nit;
}

public void setNit(String nit) {
	this.nit = nit;
}

public Date getFecha_nacimiento() {
	return fecha_nacimiento;
}

public void setFecha_nacimiento(Date fecha_nacimiento) {
	this.fecha_nacimiento = fecha_nacimiento;
}

public Date getFecha_ingreso() {
	return fecha_ingreso;
}

public void setFecha_ingreso(Date fecha_ingreso) {
	this.fecha_ingreso = fecha_ingreso;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getCelular() {
	return celular;
}

public void setCelular(String celular) {
	this.celular = celular;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public Cargo getCargo() {
	return cargo;
}

public void setCargo(Cargo cargo) {
	this.cargo = cargo;
}
}
