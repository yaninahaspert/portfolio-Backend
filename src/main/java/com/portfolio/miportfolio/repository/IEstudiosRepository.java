package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Estudio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEstudiosRepository  extends CrudRepository <Estudio, Long> {
    public List<Estudio> findAll();
}
