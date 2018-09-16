package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Cliente;

public interface ICliente {
	public List<Cliente> findAll();
	public void Save(Cliente cliente);
	public Cliente findOne(String dui_cliente);
	public void delete(String dui_cliente);
}
