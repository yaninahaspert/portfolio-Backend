package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.repository.IEstudiosRepository;
import com.portfolio.miportfolio.repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProyectoServiceImpl implements IProyectoService{
        @Autowired
        private IProyectoRepository proyectoRepository;

        @Override
        @Transactional
        public List<Proyecto> findAll() {
            return (List<Proyecto>) proyectoRepository.findAll();
        }
}
