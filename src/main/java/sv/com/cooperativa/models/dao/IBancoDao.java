package sv.com.cooperativa.models.dao;

import org.springframework.data.repository.CrudRepository;
import sv.com.cooperativa.models.entities.Banco;

public interface IBancoDao extends CrudRepository<Banco, Integer> {
		
}
