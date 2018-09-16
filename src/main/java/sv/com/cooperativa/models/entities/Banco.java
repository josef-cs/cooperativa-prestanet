package sv.com.cooperativa.models.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="bancos")
public class Banco {
	
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "banco_seq")
@SequenceGenerator(name = "banco_seq", sequenceName = "banco_seq", allocationSize=1)
private Integer id_banco;
@NotEmpty
@NotNull
private String codigo;
@NotEmpty
@NotNull
private String nombre;
@NotEmpty
@NotNull
@Pattern(regexp="[0-9]{4}-[0-9]{6}-[0-9]{3}-[0-9]", message="NIT no válido.")
private String nit;
@NotEmpty
@NotNull
private String numero_cuenta;

public Banco() {}

public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getNit() {
	return nit;
}


public void setNit(String nit) {
	this.nit = nit;
}


public String getNumero_cuenta() {
	return numero_cuenta;
}


public void setNumero_cuenta(String numero_cuenta) {
	this.numero_cuenta = numero_cuenta;
}


public String getCodigo() {
	return codigo;
}


public void setCodigo(String codigo) {
	this.codigo = codigo;
}


public void setId_banco(int id_banco) {
	this.id_banco = id_banco;
}

public Integer getId_banco() {
	return id_banco;
}

public void setId_banco(Integer id_banco) {
	this.id_banco = id_banco;
}

}
