package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.cooperativa.models.entities.Cargo;
import sv.com.cooperativa.models.dao.ICargoDao;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class CargoServiceImpl implements ICargo{
	@Autowired
	private ICargoDao cargoDao;
	
	@Override
	@Transactional
	public List<Cargo> findAll()
	{
		return (List<Cargo>) cargoDao.findAll();
	}
	
	@Override
	@Transactional
	public Cargo findOne(Integer id_cargo)
	{
		return cargoDao.findById(id_cargo).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Cargo cargo)
	{
		cargoDao.save(cargo);
	}
	
	@Override
	@Transactional
	public void delete(Integer id_banco)
	{
		cargoDao.deleteById(id_banco);
	}
}
