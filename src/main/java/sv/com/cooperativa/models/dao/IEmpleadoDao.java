package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado, String>{

}
