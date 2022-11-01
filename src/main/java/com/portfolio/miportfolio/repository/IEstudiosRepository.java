package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Estudios;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEstudiosRepository  extends CrudRepository <Estudios, Long> {
    public List<Estudios> findAll();
}
