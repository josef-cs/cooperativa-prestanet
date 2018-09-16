package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.IRemesaDao;
import sv.com.cooperativa.models.entities.Remesa;

@Service
public class RemesaServiceImpl implements IRemesa{
	@Autowired
	private IRemesaDao remesaDao;
	
	@Override
	@Transactional
	public List<Remesa> findAll()
	{
		return (List<Remesa>) remesaDao.findAll();
	}
	
	@Override
	@Transactional
	public Remesa findOne(Long id_remesa)
	{
		return remesaDao.findById(id_remesa).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Remesa remesa)
	{
		remesaDao.save(remesa);
	}
	
	@Override
	@Transactional
	public void delete(Long id_remesa)
	{
		remesaDao.deleteById(id_remesa);
	}
}
