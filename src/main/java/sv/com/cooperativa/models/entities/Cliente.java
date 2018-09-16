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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente {
@Id
private String dui_cliente;
@NotNull
@NotEmpty
private String nombres;
@NotNull
@NotEmpty
private String apellidos;
@NotNull
@NotEmpty
private String nit;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date fecha_nacimiento;
@NotNull
@NotEmpty
private String telefono;
@Email
private String correo;
@NotNull
@NotEmpty
private String estado;
@NotNull
@NotEmpty
private String referente;
@NotNull
@NotEmpty
private String telefono_referente;
@NotNull
@NotEmpty
private String direccion_referente;

public String getDui_cliente() {
	return dui_cliente;
}
public void setDui_cliente(String dui_cliente) {
	this.dui_cliente = dui_cliente;
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
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
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
public String getReferente() {
	return referente;
}
public void setReferente(String referente) {
	this.referente = referente;
}
public String getTelefono_referente() {
	return telefono_referente;
}
public void setTelefono_referente(String telefono_referente) {
	this.telefono_referente = telefono_referente;
}
public String getDireccion_referente() {
	return direccion_referente;
}
public void setDireccion_referente(String direccion_referente) {
	this.direccion_referente = direccion_referente;
}

}
