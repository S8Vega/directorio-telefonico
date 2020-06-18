package com.springboot.app.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.app.modelo.dao.IContactoDao;
import com.springboot.app.modelo.entidad.Contacto;

@Controller
public class ContactoControlador {

	@Autowired
	private IContactoDao contactoDao;

	@GetMapping(value = { "/", "/listar" })
	public String listar(Map<String, Object> model) {
		model.put("titulo", "contactos");
		model.put("contactos", contactoDao.findAll());
		return "listar";
	}

	@GetMapping(value = "/formulario")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "formulario de contacto");
		Contacto contacto = new Contacto();
		model.put("contacto", contacto);
		return "formulario";
	}

	@PostMapping(value = "/formulario")
	public String guardar(Contacto contacto) {
		contactoDao.save(contacto);
		return "redirect:listar";
	}
}
