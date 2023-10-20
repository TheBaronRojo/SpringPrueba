package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("")
	public String Index()
	{
		
		return "params/index";
	}

	@GetMapping("/parametro")
	public String param(@RequestParam(name="texto", required=false, defaultValue="No hay datos") String texto, Model model)
	{
		model.addAttribute("texto","El valor enviado es: " + texto);
		return "params/ver";
	}
	
	
}
