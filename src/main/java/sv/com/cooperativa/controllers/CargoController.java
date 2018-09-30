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
import sv.com.cooperativa.models.services.ICargo;
import sv.com.cooperativa.models.services.IArea;
import sv.com.cooperativa.models.entities.Area;

@Controller
@SessionAttributes("cargo")
public class CargoController {

	@Autowired
	private ICargo cargoService;
	@Autowired
	private IArea areaService;
	
	@RequestMapping(value="/cargo/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "numero de cuenta");
		model.addAttribute("cargos", cargoService.findAll());
		return "cargo/listar";
	}
	
	@RequestMapping(value="/cargo/crear")
	public String crear(Map<String, Object> model)
	{
		Cargo cargo = new Cargo();
		List<Area> areas = areaService.findAll();
		model.put("cargo", cargo);
		model.put("areas", areas);
		model.put("titulo", "Nuevo Cargo");
		return "cargo/crear";
	}
	
	@RequestMapping(value="/cargo/eliminar/{id}", method=RequestMethod.GET)
	public String eliminar(@PathVariable(value="id") Integer id_cargo, RedirectAttributes flash)
	{
		cargoService.delete(id_cargo);		
		flash.addFlashAttribute("success","Cargo eliminado con exito");
		return "redirect:/cargo/listar";
	}
	
	@RequestMapping(value="/cargo/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("cargo") @Valid Cargo cargo, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "cargo/crear";
		}
		cargoService.Save(cargo);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Area creada con exito");
		return "redirect:listar";
	}
	
	@RequestMapping(value="/cargo/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Integer id_cargo, RedirectAttributes flash, Map<String, Object> model)
	{
		Cargo cargo = null;
		List<Area> areas = areaService.findAll();
		model.put("areas", areas);
		cargo = cargoService.findOne(id_cargo);
		model.put("cargo", cargo);
		model.put("titulo", "Editar Cargo");
		return "cargo/crear";
	}
	
	@RequestMapping(value="/cargo/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Integer id_cargo, Map<String, Object> model)
	{
		Cargo cargo = cargoService.findOne(id_cargo);
		model.put("cargo", cargo);
		model.put("titulo", "Ver Cargo");
		return "cargo/ver";
	}
}
