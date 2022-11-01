package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Redes;
import com.portfolio.miportfolio.repository.IEstudiosRepository;
import com.portfolio.miportfolio.repository.IRedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.servlet.oauth2.login.RedirectionEndpointDsl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RedesReviceImpl implements IRedesService{
    @Autowired
    private IRedesRepository redesRepository;

    @Override
    @Transactional
    public List<Redes> findAll() {
        return (List<Redes>) redesRepository.findAll();
    }
}

