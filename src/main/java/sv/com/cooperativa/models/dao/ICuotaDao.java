package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Cuota;

public interface ICuotaDao extends CrudRepository<Cuota, Long>{

}
