package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Persona;

import javax.transaction.Transactional;
import java.util.List;

public interface IPersonaService {
    public List<Persona> findAll();

    @Transactional
    Persona findById(Long id);

    public Persona save (Persona persona);

    public void delete (Long id);
}
