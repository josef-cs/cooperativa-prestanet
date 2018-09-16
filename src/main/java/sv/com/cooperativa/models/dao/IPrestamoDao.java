package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Prestamo;

public interface IPrestamoDao extends CrudRepository<Prestamo, Long>{

}
