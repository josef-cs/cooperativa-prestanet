package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.IEmpleadoDao;
import sv.com.cooperativa.models.entities.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	@Transactional
	public List<Empleado> findAll()
	{
		return (List<Empleado>) empleadoDao.findAll();
	}
	
	@Override
	@Transactional
	public Empleado findOne(String dui_empleado)
	{
		return empleadoDao.findById(dui_empleado).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Empleado empleado)
	{
		empleadoDao.save(empleado);
	}
	
	@Override
	@Transactional
	public void delete(String dui_empleado)
	{
		empleadoDao.deleteById(dui_empleado);
	}
}
