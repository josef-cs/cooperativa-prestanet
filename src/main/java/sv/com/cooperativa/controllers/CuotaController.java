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

import sv.com.cooperativa.models.entities.Cuota;
import sv.com.cooperativa.models.services.ICuota;

@Controller
@SessionAttributes("cuota")
public class CuotaController {

	@Autowired
	private ICuota cuotaService;
	
	@RequestMapping(value="/cuota/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "cuotas");
		model.addAttribute("cuotas", cuotaService.findAll());
		return "cuota/listar";
	}
	
	@RequestMapping(value="/cuota/crear")
	public String crear(Map<String, Object> model)
	{
		Cuota cuota = new Cuota();
		model.put("cuota", cuota);
		model.put("titulo", "Cuotas");
		return "cuota/crear";
	}
	
	@RequestMapping(value="/cuota/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Long id_cuota, RedirectAttributes flash)
	{
		cuotaService.delete(id_cuota);		
		flash.addFlashAttribute("success","Cuota eliminada con exito");
		return "redirect:/cuota/listar";
	}
	
	@RequestMapping(value="/cuota/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("cuota") @Valid Cuota cuota, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "cuota/crear";
		}
		cuotaService.Save(cuota);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Cuota creada con exito");
		return "redirect:cuota/listar";
	}
	
	@RequestMapping(value="/cuota/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Long id_cuota, RedirectAttributes flash, Map<String, Object> model)
	{
		Cuota cuota = null;
		cuota = cuotaService.findOne(id_cuota);
		model.put("cuota", cuota);
		model.put("titulo", "Editar Cuota");
		return "cuota/crear";
	}
	
	@RequestMapping(value="/cuota/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Long id_cuota, Map<String, Object> model)
	{
		Cuota cuota = cuotaService.findOne(id_cuota);
		model.put("cuota", cuota);
		model.put("titulo", "Ver Cuota");
		return "cuota/ver";
	}
}
