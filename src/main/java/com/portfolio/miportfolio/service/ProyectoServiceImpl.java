package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import com.portfolio.miportfolio.repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProyectoServiceImpl implements IProyectoService{
        @Autowired
        private IProyectoRepository proyectoRepository;

        @Autowired
        private IPersonaRepository personaRepository;

        @Autowired
        private UsuarioService usuarioService;

        @Override
        @Transactional
        public List<Proyecto> findByIdPersona(Long idPersona) {
                var persona = this.personaRepository.findById(idPersona).get();

                return proyectoRepository.findByPersona(persona);
        }
        @Override
        @Transactional
        public Proyecto findById(Long id) {
                return proyectoRepository.findById(id).orElse(null);
        }

        @Override
        @Transactional
        public Proyecto save(Proyecto proyecto) {
                proyecto.setPersona(this.usuarioService.getUsuarioLogueado().getPersona());

                return proyectoRepository.save(proyecto);
        }

        @Override
        @Transactional
        public void delete(Long id) {
                proyectoRepository.deleteById(id);
        }
}
