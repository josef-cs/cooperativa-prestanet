package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.ISolicitudDao;
import sv.com.cooperativa.models.entities.Solicitud;

@Service
public class SolicitudServiceImpl implements ISolicitud{
	@Autowired
	private ISolicitudDao solicitudDao;
	
	@Override
	@Transactional
	public List<Solicitud> findAll()
	{
		return (List<Solicitud>) solicitudDao.findAll();
	}
	
	@Override
	@Transactional
	public Solicitud findOne(Long id_solicitud)
	{
		return solicitudDao.findById(id_solicitud).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Solicitud solicitud)
	{
		solicitudDao.save(solicitud);
	}
	
	@Override
	@Transactional
	public void delete(Long id_solicitud)
	{
		solicitudDao.deleteById(id_solicitud);
	}
}
