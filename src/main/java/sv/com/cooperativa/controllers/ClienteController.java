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

import sv.com.cooperativa.models.entities.Cliente;
import sv.com.cooperativa.models.services.ICliente;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	private ICliente clienteService;
	
	@RequestMapping(value="/cliente/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "clientes/listar";
	}
	
	@RequestMapping(value="/cliente/crear")
	public String crear(Map<String, Object> model)
	{
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Modificar Cliente");
		return "/clientes/crear";
	}
	
	@RequestMapping(value="/cliente/eliminar/{id}", method=RequestMethod.GET)
	public String eliminar(@PathVariable(value="id") String dui_cliente, RedirectAttributes flash)
	{
		clienteService.delete(dui_cliente);		
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/clientes/listar";
	}
	
	@RequestMapping(value="/cliente/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "/clientes/crear";
		}
		/*Cliente cli = null;
		cli = clienteService.findOne(cliente.getDui_cliente());
		if(cli != null)
		{
			return "Ya existe este dui";
		}*/
		clienteService.Save(cliente);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Cliente creado con exito");
		return "redirect:/cliente/listar";
	}
	
	@RequestMapping(value="/cliente/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") String dui_cliente, RedirectAttributes flash, Map<String, Object> model)
	{
		Cliente cliente = null;
		cliente = clienteService.findOne(dui_cliente);
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "/clientes/crear";
	}
	
	@RequestMapping(value="/cliente/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") String dui_cliente, Map<String, Object> model)
	{
		Cliente cliente = clienteService.findOne(dui_cliente);
		model.put("cliente", cliente);
		model.put("titulo", "Ver Banco");
		return "/clientes/ver";
	}
}
