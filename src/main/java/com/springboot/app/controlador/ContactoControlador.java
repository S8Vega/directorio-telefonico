package com.springboot.app.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.app.modelo.dao.IContactoDao;

@Controller
public class ContactoControlador {

	@Autowired
	private IContactoDao contactoDao;

	@GetMapping(value = "/")
	public String listar(Map<String, Object> model) {
		model.put("titulo", "contactos");
		model.put("contactos", contactoDao.findAll());
		return "listar";
	}
}
