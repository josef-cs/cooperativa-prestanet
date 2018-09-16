package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Pago;

public interface IPago {
	public List<Pago> findAll();
	public void Save(Pago pago);
	public Pago findOne(Long id_pago);
	public void delete(Long id_pago);
}
