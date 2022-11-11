package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;

import javax.transaction.Transactional;
import java.util.List;

public interface IEstudiosService {
    @Transactional
    public List<Estudio> findAll();

    @Transactional
    public List<Estudio> findByIdUsuario(Long idUsuario);

    public Estudio findById(Long id);

    public Estudio save (Estudio estudio);

    public void delete (Long id);
}
