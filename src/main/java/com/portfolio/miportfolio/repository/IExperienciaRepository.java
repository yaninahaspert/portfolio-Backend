package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.entity.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IExperienciaRepository extends CrudRepository<Experiencia, Long> {
    public List<Experiencia> findByPersona(Persona persona);
}