package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.entity.Redes;

import javax.transaction.Transactional;
import java.util.List;

public interface IRedesService {
    @Transactional
    List<Redes> findByIdPersona(Long idPersona);

    public Redes findById(Long id);

    public Redes save(Redes redes);

    public void delete(Long id);
}