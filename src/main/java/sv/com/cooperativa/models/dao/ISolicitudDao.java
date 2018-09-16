package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Solicitud;

public interface ISolicitudDao extends CrudRepository<Solicitud, Long>{

}
