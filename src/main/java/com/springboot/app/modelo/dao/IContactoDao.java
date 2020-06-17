package com.springboot.app.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.modelo.entidad.Contacto;

public interface IContactoDao extends CrudRepository<Contacto, Long> {

}
