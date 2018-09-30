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

import sv.com.cooperativa.models.entities.TasaInteres;
import sv.com.cooperativa.models.services.ITasaInteres;

@Controller
@SessionAttributes("tasainteres")
public class TasaInteresController {

	@Autowired
	private ITasaInteres interesService;
	
	@RequestMapping(value="/tasainteres/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Tasas de Interés");
		model.addAttribute("tasasinteres", interesService.findAll());
		return "tasainteres/listar";
	}
	
	@RequestMapping(value="/tasainteres/crear")
	public String crear(Map<String, Object> model)
	{
		TasaInteres tasainteres = new TasaInteres();
		model.put("tasainteres", tasainteres);
		model.put("titulo", "Tasa de Interes");
		return "tasainteres/crear";
	}
	
	@RequestMapping(value="/tasainteres/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Integer id_tasa_interes, RedirectAttributes flash)
	{
		interesService.delete(id_tasa_interes);		
		flash.addFlashAttribute("success","Tasa de interés eliminada con exito");
		return "redirect:/tasainteres/listar";
	}
	
	@RequestMapping(value="/tasainteres/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("tasainteres") @Valid TasaInteres tasainteres, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "tasainteres/crear";
		}
		interesService.Save(tasainteres);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Tasa de interés creada con exito");
		return "redirect:/tasainteres/listar";
	}
	
	@RequestMapping(value="/tasainteres/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Integer id_tasa_interes, RedirectAttributes flash, Map<String, Object> model)
	{
		TasaInteres tasainteres = null;
		tasainteres = interesService.findOne(id_tasa_interes);
		model.put("tasainteres", tasainteres);
		model.put("titulo", "Editar Tasa de interés");
		return "tasainteres/crear";
	}
	
	@RequestMapping(value="/tasainteres/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Integer id_tasa_interes, Map<String, Object> model)
	{
		TasaInteres tasainteres = interesService.findOne(id_tasa_interes);
		model.put("tasainteres", tasainteres);
		model.put("titulo", "Ver Tasa de Interés");
		return "tasainteres/ver";
	}
}
