package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Prestamo;

public interface IPrestamo {
	public List<Prestamo> findAll();
	public void Save(Prestamo prestamo);
	public Prestamo findOne(Long id_prestamo);
	public void delete(Long id_prestamo);
}
