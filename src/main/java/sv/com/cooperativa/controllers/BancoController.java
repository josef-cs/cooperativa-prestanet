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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.cooperativa.models.entities.Banco;
import sv.com.cooperativa.models.services.IBancoService;

@Controller
@SessionAttributes("banco")
public class BancoController {

	@Autowired
	private IBancoService bancoService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "numero de cuenta");
		model.addAttribute("bancos", bancoService.findAll());
		return "banco/listar";
	}
	
	@RequestMapping(value="/crear")
	public String crear(Map<String, Object> model)
	{
		Banco banco = new Banco();
		model.put("banco", banco);
		model.put("titulo", "Nuevo Banco");
		return "banco/crear";
	}
	
	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
	public String eliminar(@PathVariable(value="id") Integer id_banco, RedirectAttributes flash)
	{
		bancoService.delete(id_banco);		
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute("banco") @Valid Banco banco, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus)
	{
		if(bindingResult.hasErrors()) {
			return "banco/crear";
		}
		bancoService.Save(banco);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success", "Cliente creado con exito");
		return "redirect:listar";
	}
	
	@RequestMapping(value="/modificar/{id}", method=RequestMethod.GET)
	public String modificar(@PathVariable(value="id") Integer id_banco, RedirectAttributes flash, Map<String, Object> model)
	{
		Banco banco = null;
		banco = bancoService.findOne(id_banco);
		model.put("banco", banco);
		model.put("titulo", "Editar Banco");
		return "banco/crear";
	}
	
	@RequestMapping(value="/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value="id") Integer id_banco, Map<String, Object> model)
	{
		Banco banco = bancoService.findOne(id_banco);
		model.put("banco", banco);
		model.put("titulo", "Ver Banco");
		return "banco/ver";
	}
}
