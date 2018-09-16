package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.IPrestamoDao;
import sv.com.cooperativa.models.entities.Prestamo;

@Service
public class PrestamoServiceImpl implements IPrestamo{
	@Autowired
	private IPrestamoDao prestamoDao;
	
	@Override
	@Transactional
	public List<Prestamo> findAll()
	{
		return (List<Prestamo>) prestamoDao.findAll();
	}
	
	@Override
	@Transactional
	public Prestamo findOne(Long id_prestamo)
	{
		return prestamoDao.findById(id_prestamo).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Prestamo prestamo)
	{
		prestamoDao.save(prestamo);
	}
	
	@Override
	@Transactional
	public void delete(Long id_prestamo)
	{
		prestamoDao.deleteById(id_prestamo);
	}
}
