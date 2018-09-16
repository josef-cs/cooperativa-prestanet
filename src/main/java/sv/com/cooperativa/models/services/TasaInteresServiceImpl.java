package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.ITasaInteresDao;
import sv.com.cooperativa.models.entities.TasaInteres;

@Service
public class TasaInteresServiceImpl implements ITasaInteres{
	@Autowired
	private ITasaInteresDao tasaInteresDao;
	
	@Override
	@Transactional
	public List<TasaInteres> findAll()
	{
		return (List<TasaInteres>) tasaInteresDao.findAll();
	}
	
	@Override
	@Transactional
	public TasaInteres findOne(Long id_tasa_interes)
	{
		return tasaInteresDao.findById(id_tasa_interes).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(TasaInteres tasa_interes)
	{
		tasaInteresDao.save(tasa_interes);
	}
	
	@Override
	@Transactional
	public void delete(Long id_tasa_interes)
	{
		tasaInteresDao.deleteById(id_tasa_interes);
	}
}
