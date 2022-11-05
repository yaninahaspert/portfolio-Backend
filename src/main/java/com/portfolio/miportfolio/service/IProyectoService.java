package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Proyecto;

import javax.transaction.Transactional;
import java.util.List;

public interface IProyectoService {
    @Transactional
    List<Proyecto> findAll();

    public Proyecto findById(Long id);

    public Proyecto save (Proyecto proyecto);

    public void delete (Long id);
}
