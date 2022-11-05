package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Persona;

import javax.transaction.Transactional;
import java.util.List;

public interface IEstudiosService {
    @Transactional
    public List<Estudio> findAll();

    public Estudio findById(Long id);

    public Estudio save (Estudio estudio);

    public void delete (Long id);
}
