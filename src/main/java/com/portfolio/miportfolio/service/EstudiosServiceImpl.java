package com.portfolio.miportfolio.service;
import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.repository.IEstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudiosServiceImpl  implements IEstudiosService {
    @Autowired
    private IEstudiosRepository estudiosRepository;

    @Override
    @Transactional
    public List<Estudio> findAll() {
        return (List<Estudio>) estudiosRepository.findAll();
    }

    @Override
    @Transactional
    public Estudio findById(Long id) {
        return estudiosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Estudio save(Estudio estudio) {
        return estudiosRepository.save(estudio);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estudiosRepository.deleteById(id);
    }

}

