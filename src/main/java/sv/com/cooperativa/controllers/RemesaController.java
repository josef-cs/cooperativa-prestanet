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

import sv.com.cooperativa.models.entities.Remesa;
import sv.com.cooperativa.models.services.IRemesa;

@Controller
@SessionAttributes("prestamo")
public class RemesaController {

	@Autowired
	private IRemesa remesaService;
	
	@RequestMapping(value="/remesa/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Remesas");
		model.addAttribute("remesas", remesaService.findAll());
		return "remesa/listar";
	}
	
	@RequestMapping(value="/remesa/crear")
	public String crear(Map<String, Object> model)
	{
		Remesa remesa = new Remesa();
		model.put("remesa", remesa);
		model.put("titulo", "Remesas");
		return "remesa/crear";
	}
	
	@RequestMapping(value="/remesa/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Long id_remesa, RedirectAttributes flash)
	{
		remesaService.delete(id_remesa);		
		flash.addFlashAttribute("success","Remesa eliminada con exito");
		return "redirect:/remesa/listar";
	}
	
	@RequestMapping(value="/remesa/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("remesa") @Valid Remesa remesa, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "prestamo/crear";
		}
		remesaService.Save(remesa);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Remesa creada con exito");
		return "redirect:remesa/listar";
	}
	
	@RequestMapping(value="/remesa/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Long id_remesa, RedirectAttributes flash, Map<String, Object> model)
	{
		Remesa remesa = null;
		remesa = remesaService.findOne(id_remesa);
		model.put("remesa", remesa);
		model.put("titulo", "Editar Remesa");
		return "remesa/crear";
	}
	
	@RequestMapping(value="/remesa/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Long id_remesa, Map<String, Object> model)
	{
		Remesa remesa = remesaService.findOne(id_remesa);
		model.put("remesa", remesa);
		model.put("titulo", "Ver Remesa");
		return "remesa/ver";
	}
}
