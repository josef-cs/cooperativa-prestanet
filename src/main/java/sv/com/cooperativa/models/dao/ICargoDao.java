package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Cargo;

public interface ICargoDao extends CrudRepository<Cargo, Long> {

}
