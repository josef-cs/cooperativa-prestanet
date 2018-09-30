package sv.com.cooperativa.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sv.com.cooperativa.models.entities.Prestamo;

@Repository
public interface IPrestamoDao extends CrudRepository<Prestamo, Long>{

}
