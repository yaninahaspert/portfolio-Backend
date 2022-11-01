package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.repository.IEstudiosRepository;
import com.portfolio.miportfolio.repository.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExperienciaServiceImpl implements IExperienciaService{
    @Autowired
    private IExperienciaRepository experienciaRepository;

    @Override
    @Transactional
    public List<Experiencia> findAll() {
        return (List<Experiencia>) experienciaRepository.findAll();
    }

}
