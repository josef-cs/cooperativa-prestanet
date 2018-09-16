package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Cuota;

public interface ICuota {
	public List<Cuota> findAll();
	public void Save(Cuota cuota);
	public Cuota findOne(Long id_cuota);
	public void delete(Long id_cuota);
}