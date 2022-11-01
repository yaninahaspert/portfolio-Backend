package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudios;

import javax.transaction.Transactional;
import java.util.List;

public interface IEstudiosService {
    @Transactional
    List<Estudios> findAll();
}
