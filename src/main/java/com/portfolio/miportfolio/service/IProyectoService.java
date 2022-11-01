package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Proyecto;

import javax.transaction.Transactional;
import java.util.List;

public interface IProyectoService {
    @Transactional
    List<Proyecto> findAll();
}
