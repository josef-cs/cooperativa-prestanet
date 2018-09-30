package sv.com.cooperativa.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sv.com.cooperativa.models.entities.Cargo;
import sv.com.cooperativa.models.entities.Empleado;
import sv.com.cooperativa.models.services.ICargo;
import sv.com.cooperativa.models.services.IEmpleadoService;

@Controller
@SessionAttributes("empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private ICargo cargoService;
	@RequestMapping(value="/empleado/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "empleados");
		model.addAttribute("empleados", empleadoService.findAll());
		return "/empleado/listar";
	}
	
	@RequestMapping(value="/empleado/crear")
	public String crear(Map<String, Object> model)
	{
		Empleado empleado = new Empleado();
		List<Cargo> cargos = cargoService.findAll();
		model.put("cargos", cargos);
		model.put("empleado", empleado);		
		model.put("titulo", "Empleados");
		return "/empleado/crear";
	}
	
	@RequestMapping(value="/empleado/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") String dui_empleado, RedirectAttributes flash)
	{
		empleadoService.delete(dui_empleado);		
		flash.addFlashAttribute("success","Empleado eliminado con exito");
		return "redirect:/empleado/listar";
	}
	
	@RequestMapping(value="/empleado/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("empleado") @Valid Empleado empleado, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "/empleado/crear";
		}
		empleadoService.Save(empleado);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Empleado creado con exito");
		return "redirect:/empleado/listar";
	}
	
	@RequestMapping(value="/empleado/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") String dui_empleado, RedirectAttributes flash, Map<String, Object> model)
	{
		Empleado empleado = null;
		List<Cargo> cargos = cargoService.findAll();
		empleado = empleadoService.findOne(dui_empleado);
		model.put("empleado", empleado);
		model.put("cargos", cargos);
		model.put("titulo", "Editar Empleado");
		return "empleado/crear";
	}
	
	@RequestMapping(value="/empleado/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") String dui_empleado, Map<String, Object> model)
	{
		Empleado empleado = empleadoService.findOne(dui_empleado);
		model.put("empleado", empleado);
		model.put("titulo", "Ver Empleado");
		return "empleado/ver";
	}
}
