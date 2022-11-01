package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Redes;

import javax.transaction.Transactional;
import java.util.List;

public interface IRedesService {
    @Transactional
    List<Redes> findAll();
}
