package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.entity.Proyecto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProyectoRepository extends CrudRepository<Proyecto, Long> {
    public List<Proyecto> findByPersona(Persona persona);
}