package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Solicitud;

public interface ISolicitud {
	public List<Solicitud> findAll();
	public void Save(Solicitud solicitud);
	public Solicitud findOne(Long id_solicitud);
	public void delete(Long id_solicitud);
}
