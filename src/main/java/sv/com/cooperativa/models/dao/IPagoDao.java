package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.cooperativa.models.entities.Pago;

public interface IPagoDao extends CrudRepository<Pago, Long> {

}
