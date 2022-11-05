package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Experiencia;
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
    @Override
    @Transactional
    public Experiencia findById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Experiencia save(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }

}
