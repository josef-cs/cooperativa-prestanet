package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, String> {

}
