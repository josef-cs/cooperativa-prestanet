package sv.com.cooperativa.models.services;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.cooperativa.models.entities.Cliente;
import sv.com.cooperativa.models.dao.IClienteDao;

@Service
public class ClienteServiceImpl implements ICliente{
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional
	public List<Cliente> findAll()
	{
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional
	public Cliente findOne(String dui_cliente)
	{
		return clienteDao.findById(dui_cliente).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Cliente banco)
	{
		clienteDao.save(banco);
	}
	
	@Override
	@Transactional
	public void delete(String dui_cliente)
	{
		clienteDao.deleteById(dui_cliente);
	}
}
