package sv.com.cooperativa.models.services;
import java.util.List;

import sv.com.cooperativa.models.entities.Empleado;
public interface IEmpleadoService {
	public List<Empleado> findAll();
	public void Save(Empleado empleado);
	public Empleado findOne(String dui_empleado);
	public void delete(String dui_empleado);
}
