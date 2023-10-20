package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

import org.springframework.ui.Model;

@Controller /* determina que es controlador*/
@RequestMapping("/app") //Prefijo para las rutas
public class IndexController {
	
	@GetMapping({"/home","/",""})
	public String index(Model model)
	{
		model.addAttribute("titulo", "Es el home");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model)
	{
		Usuario usuario = new Usuario();
		usuario.setNombre("Pepito");
		usuario.setApellido("Jimenez");
		usuario.setEmail("ejemplo@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}
	
	/* Esto se pasa a todos los metodos */
	@ModelAttribute("usuarios")
	public List<Usuario> fillUsers()
	{
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Julian","Ramirez","Correo1@correo.com"));
		usuarios.add(new Usuario("Estefania","Sanchez","Correo2@correo.com"));
		usuarios.add(new Usuario("Felipe","Betancur","Correo3@correo.com"));
		return usuarios;
	}
	
}
