package com.springboot.app.modelo.servicio;

import java.util.List;

import com.springboot.app.modelo.entidad.Contacto;


public interface IServicio {
	public List<Contacto> findAll();

	public void save(Contacto contacto);
	
	public Contacto findById(Long id);
	
	public void delete(Long id);
}
