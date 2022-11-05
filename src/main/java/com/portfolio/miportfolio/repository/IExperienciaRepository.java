package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Experiencia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IExperienciaRepository extends CrudRepository<Experiencia, Long> {
    public List<Experiencia> findAll();
}