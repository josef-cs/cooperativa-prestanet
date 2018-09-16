package sv.com.cooperativa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("default")
public class DefaultController {

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model)
	{
		return "index";
	}

}
