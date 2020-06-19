package com.springboot.app.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.modelo.dao.IContactoDao;
import com.springboot.app.modelo.entidad.Contacto;

@Service("ContactoServicioImpl")
public class ContactoServicioImpl implements IServicio {

	@Autowired
	private IContactoDao contactoDao;

	@Override
	public List<Contacto> findAll() {
		return (List<Contacto>) contactoDao.findAll();
	}

	@Override
	public void save(Contacto contacto) {
		contactoDao.save(contacto);
	}

	@Override
	public Contacto findById(Long id) {
		return contactoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		contactoDao.deleteById(id);
	}

}
