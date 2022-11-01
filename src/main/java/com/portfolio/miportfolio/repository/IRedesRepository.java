package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Redes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRedesRepository extends CrudRepository<Redes, Long> {
    public List<Redes> findAll();
}
