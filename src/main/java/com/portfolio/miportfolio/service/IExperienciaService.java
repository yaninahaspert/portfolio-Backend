package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Experiencia;

import javax.transaction.Transactional;
import java.util.List;

public interface IExperienciaService {
    @Transactional
    List<Experiencia> findByIdPersona(Long idPersona);

    public Experiencia findById(Long id);

    public Experiencia save (Experiencia experiencia);

    public void delete (Long id);
}
