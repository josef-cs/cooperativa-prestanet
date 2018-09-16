package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.ICuotaDao;
import sv.com.cooperativa.models.entities.Cuota;

@Service
public class CuotaServiceImpl implements ICuota{
	@Autowired
	private ICuotaDao cuotaDao;
	
	@Override
	@Transactional
	public List<Cuota> findAll()
	{
		return (List<Cuota>) cuotaDao.findAll();
	}
	
	@Override
	@Transactional
	public Cuota findOne(Long id_cuota)
	{
		return cuotaDao.findById(id_cuota).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Cuota cuota)
	{
		cuotaDao.save(cuota);
	}
	
	@Override
	@Transactional
	public void delete(Long id_cuota)
	{
		cuotaDao.deleteById(id_cuota);
	}
}
