package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.TasaInteres;

public interface ITasaInteres {
	public List<TasaInteres> findAll();
	public void Save(TasaInteres tasa_interes);
	public TasaInteres findOne(Long id_tasa_interes);
	public void delete(Long id_tasa_interes);
}
