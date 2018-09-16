package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Banco;

public interface IBancoService {
	public List<Banco> findAll();
	public void Save(Banco banco);
	public Banco findOne(Integer id_banco);
	public void delete(Integer id_banco);
}
