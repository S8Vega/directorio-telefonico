package com.springboot.app.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboot.app.modelo.entidad.Contacto;
import com.springboot.app.modelo.servicio.IServicio;

@Controller
@SessionAttributes("contacto")
public class ContactoControlador {

	@Autowired
	@Qualifier("ContactoServicioImpl")
	private IServicio contactoServicio;

	@GetMapping({ "/", "/listar" })
	public String listar(Map<String, Object> model) {
		model.put("titulo", "contactos");
		model.put("contactos", contactoServicio.findAll());
		Contacto contacto = new Contacto();
		model.put("contacto", contacto);
		return "listar";
	}

	@GetMapping("/formulario")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "formulario de contacto");
		Contacto contacto = new Contacto();
		model.put("contacto", contacto);
		return "formulario";
	}

	@PostMapping("/formulario")
	public String guardar(Contacto contacto, SessionStatus status) {
		contactoServicio.save(contacto);
		status.setComplete();
		return "redirect:listar";
	}

	@GetMapping("/formulario/{id}")
	public String editar(@PathVariable Long id, Map<String, Object> model) {
		Contacto contacto = contactoServicio.findById(id);
		model.put("contacto", contacto);
		model.put("titulo", "formulario de contacto");
		return "formulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		contactoServicio.delete(id);
		return "redirect:/listar";
	}

	@PostMapping("/buscar")
	public String buscarPorNombre(Contacto contacto, Map<String, Object> model) {
		if (contacto.getNombre() == null)
			return "redirect:/listar";
		List<Contacto> lista = contactoServicio.findAll();
		List<Contacto> listaContactos = new ArrayList<>();
		for (Contacto c : lista) {
			if (c.getNombre().toLowerCase().contains(contacto.getNombre().toLowerCase()))
				listaContactos.add(c);
		}
		model.put("titulo", "contactos");
		model.put("contactos", listaContactos);
		return "listar";
	}
}
