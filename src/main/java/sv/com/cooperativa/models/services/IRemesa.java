package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Remesa;

public interface IRemesa {
	public List<Remesa> findAll();
	public void Save(Remesa banco);
	public Remesa findOne(Long id_remesa);
	public void delete(Long id_remesa);
}
