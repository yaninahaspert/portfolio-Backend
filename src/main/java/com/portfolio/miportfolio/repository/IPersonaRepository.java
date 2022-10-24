package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaRepository extends CrudRepository<Persona, Long> {
    public Persona findTopByOrderByIdAsc();
}
