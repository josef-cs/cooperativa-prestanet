package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Cargo;

public interface ICargo {
	public List<Cargo> findAll();
	public void Save(Cargo cargo);
	public Cargo findOne(Integer id_cargo);
	public void delete(Integer id_cargo);
}