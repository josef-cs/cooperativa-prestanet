package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.IBancoDao;
import sv.com.cooperativa.models.entities.Banco;

@Service
public class BancoServiceImpl implements IBancoService{
	
	@Autowired
	private IBancoDao bancoDao;
	
	@Override
	@Transactional
	public List<Banco> findAll()
	{
		return (List<Banco>) bancoDao.findAll();
	}
	
	@Override
	@Transactional
	public Banco findOne(Integer id_banco)
	{
		return bancoDao.findById(id_banco).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Banco banco)
	{
		bancoDao.save(banco);
	}
	
	@Override
	@Transactional
	public void delete(Integer id_banco)
	{
		bancoDao.deleteById(id_banco);
	}
}
