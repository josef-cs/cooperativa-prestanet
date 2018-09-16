package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.IPagoDao;
import sv.com.cooperativa.models.entities.Pago;

@Service
public class PagoServiceImpl implements IPago{
	@Autowired
	private IPagoDao pagoDao;
	
	@Override
	@Transactional
	public List<Pago> findAll()
	{
		return (List<Pago>) pagoDao.findAll();
	}
	
	@Override
	@Transactional
	public Pago findOne(Long id_pago)
	{
		return pagoDao.findById(id_pago).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Pago pago)
	{
		pagoDao.save(pago);
	}
	
	@Override
	@Transactional
	public void delete(Long id_pago)
	{
		pagoDao.deleteById(id_pago);
	}
}
