package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Contacto;
import com.portfolio.miportfolio.entity.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IContactoRepository extends CrudRepository<Contacto, Long> {
    public List<Contacto> findAll();

    public List<Contacto> findByPersona(Persona persona);
}