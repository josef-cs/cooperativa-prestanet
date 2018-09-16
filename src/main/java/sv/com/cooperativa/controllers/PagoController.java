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

import sv.com.cooperativa.models.entities.Pago;
import sv.com.cooperativa.models.services.IPago;

@Controller
@SessionAttributes("pago")
public class PagoController {

	@Autowired
	private IPago pagoService;
	
	@RequestMapping(value="/pago/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Pagos");
		model.addAttribute("pagos", pagoService.findAll());
		return "pago/listar";
	}
	
	@RequestMapping(value="/pago/crear")
	public String crear(Map<String, Object> model)
	{
		Pago pago = new Pago();
		model.put("pago", pago);
		model.put("titulo", "Pagos");
		return "pago/crear";
	}
	
	@RequestMapping(value="/pago/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable(value="id") Long id_pago, RedirectAttributes flash)
	{
		pagoService.delete(id_pago);		
		flash.addFlashAttribute("success","Pago eliminado con exito");
		return "redirect:/pago/listar";
	}
	
	@RequestMapping(value="/pago/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("pago") @Valid Pago pago, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "pago/crear";
		}
		pagoService.Save(pago);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Pago creado con exito");
		return "redirect:cuota/listar";
	}
	
	@RequestMapping(value="/pago/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Long id_pago, RedirectAttributes flash, Map<String, Object> model)
	{
		Pago pago = null;
		pago = pagoService.findOne(id_pago);
		model.put("pago", pago);
		model.put("titulo", "Editar Cuota");
		return "pago/crear";
	}
	
	@RequestMapping(value="/pago/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Long id_pago, Map<String, Object> model)
	{
		Pago pago = pagoService.findOne(id_pago);
		model.put("pago", pago);
		model.put("titulo", "Ver Pago");
		return "pago/ver";
	}
}
