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

import sv.com.cooperativa.models.entities.Prestamo;
import sv.com.cooperativa.models.services.IPrestamo;

@Controller
@SessionAttributes("prestamo")
public class PrestamoController {

	@Autowired
	private IPrestamo prestamoService;
	
	@RequestMapping(value="/prestamo/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Prestamos");
		model.addAttribute("prestamos", prestamoService.findAll());
		return "prestamo/listar";
	}
	
	@RequestMapping(value="/prestamo/crear")
	public String crear(Map<String, Object> model)
	{
		Prestamo prestamo = new Prestamo();
		model.put("prestamo", prestamo);
		model.put("titulo", "Prestamos");
		return "prestamo/crear";
	}
	
	@RequestMapping(value="/prestamo/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Long id_prestamo, RedirectAttributes flash)
	{
		prestamoService.delete(id_prestamo);		
		flash.addFlashAttribute("success","Prestamo eliminado con exito");
		return "redirect:/prestamo/listar";
	}
	
	@RequestMapping(value="/prestamo/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("prestamo") @Valid Prestamo prestamo, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "prestamo/crear";
		}
		prestamoService.Save(prestamo);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Prestamo creado con exito");
		return "redirect:prestamo/listar";
	}
	
	@RequestMapping(value="/prestamo/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Long id_prestamo, RedirectAttributes flash, Map<String, Object> model)
	{
		Prestamo prestamo = null;
		prestamo = prestamoService.findOne(id_prestamo);
		model.put("prestamo", prestamo);
		model.put("titulo", "Editar Prestamo");
		return "prestamo/crear";
	}
	
	@RequestMapping(value="/prestamo/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Long id_prestamo, Map<String, Object> model)
	{
		Prestamo prestamo = prestamoService.findOne(id_prestamo);
		model.put("prestamo", prestamo);
		model.put("titulo", "Ver Prestamo");
		return "prestamo/ver";
	}
}
