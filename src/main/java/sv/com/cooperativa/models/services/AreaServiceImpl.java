package sv.com.cooperativa.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import sv.com.cooperativa.models.dao.IAreaDao;
import sv.com.cooperativa.models.entities.Area;


@Service
public class AreaServiceImpl implements IArea{
	@Autowired
	private IAreaDao areaDao;
	
	@Override
	@Transactional
	public List<Area> findAll()
	{
		return (List<Area>) areaDao.findAll();
	}
	
	@Override
	@Transactional
	public Area findOne(Long id_area)
	{
		return areaDao.findById(id_area).orElse(null);
	}
	
	@Override
	@Transactional
	public void Save(Area area)
	{
		areaDao.save(area);
	}
	
	@Override
	@Transactional
	public void delete(Long id_area)
	{
		areaDao.deleteById(id_area);
	}
}
