package sv.com.cooperativa.controllers;

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

import sv.com.cooperativa.models.entities.Area;
import sv.com.cooperativa.models.services.IArea;

@Controller
@SessionAttributes("area")
public class AreaController {

	@Autowired
	private IArea areaService;
	
	@RequestMapping(value="/area/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "numero de cuenta");
		model.addAttribute("areas", areaService.findAll());
		return "area/listar";
	}
	
	@RequestMapping(value="/area/crear")
	public String crear(Map<String, Object> model)
	{
		Area area = new Area();
		model.put("area", area);
		model.put("titulo", "Nueva Area");
		return "area/crear";
	}
	
	@RequestMapping(value="/area/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Long id_area, RedirectAttributes flash)
	{
		areaService.delete(id_area);		
		flash.addFlashAttribute("success","Area eliminada con exito");
		return "redirect:/area/listar";
	}
	
	@RequestMapping(value="/area/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("area") @Valid Area area, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "area/crear";
		}
		areaService.Save(area);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Area creada con exito");
		return "redirect:listar";
	}
	
	@RequestMapping(value="area/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Long id_area, RedirectAttributes flash, Map<String, Object> model)
	{
		Area area = null;
		area = areaService.findOne(id_area);
		model.put("area", area);
		model.put("titulo", "Editar Area");
		return "area/crear";
	}
	
	@RequestMapping(value="area/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Long id_area, Map<String, Object> model)
	{
		Area area = areaService.findOne(id_area);
		model.put("area", area);
		model.put("titulo", "Ver Area");
		return "area/ver";
	}
}
