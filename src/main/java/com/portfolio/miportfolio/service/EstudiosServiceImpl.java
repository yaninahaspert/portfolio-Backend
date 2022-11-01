package com.portfolio.miportfolio.service;
import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.repository.IEstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudiosServiceImpl  implements IEstudiosService{
    @Autowired
    private IEstudiosRepository estudiosRepository;

    @Override
    @Transactional
    public List<Estudios> findAll() {
        return (List<Estudios>) estudiosRepository.findAll();
    }

}
