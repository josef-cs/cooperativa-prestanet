package sv.com.cooperativa.models.services;

import java.util.List;

import sv.com.cooperativa.models.entities.Area;

public interface IArea {
	public List<Area> findAll();
	public void Save(Area banco);
	public Area findOne(Integer id_area);
	public void delete(Integer id_area);
}
