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

import sv.com.cooperativa.models.entities.Solicitud;
import sv.com.cooperativa.models.services.ISolicitud;

@Controller
@SessionAttributes("solicitud")
public class SolicitudController {

	@Autowired
	private ISolicitud solicitudService;
	
	@RequestMapping(value="/solicitud/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Solicitudes");
		model.addAttribute("solicitudes", solicitudService.findAll());
		return "solicitud/listar";
	}
	
	@RequestMapping(value="/solicitud/crear")
	public String crear(Map<String, Object> model)
	{
		Solicitud solicitud = new Solicitud();
		model.put("solicitud", solicitud);
		model.put("titulo", "Solicitud");
		return "solicitud/crear";
	}
	
	@RequestMapping(value="/solicitud/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Long id_solicitud, RedirectAttributes flash)
	{
		solicitudService.delete(id_solicitud);		
		flash.addFlashAttribute("success","Solicitud eliminada con exito");
		return "redirect:/solicitud/listar";
	}
	
	@RequestMapping(value="/solicitud/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("solicitud") @Valid Solicitud solicitud, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "solicitud/crear";
		}
		solicitudService.Save(solicitud);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Solicitud creada con exito");
		return "redirect:solicitud/listar";
	}
	
	@RequestMapping(value="/solicitud/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Long id_solicitud, RedirectAttributes flash, Map<String, Object> model)
	{
		Solicitud solicitud = null;
		solicitud = solicitudService.findOne(id_solicitud);
		model.put("solicitud", solicitud);
		model.put("titulo", "Editar Solicitud");
		return "solicitud/crear";
	}
	
	@RequestMapping(value="/solicitud/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Long id_solicitud, Map<String, Object> model)
	{
		Solicitud solicitud = solicitudService.findOne(id_solicitud);
		model.put("solicitud", solicitud);
		model.put("titulo", "Ver Solicitud");
		return "solicitud/ver";
	}
}
