package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.repository.IEstudiosRepository;
import com.portfolio.miportfolio.repository.IExperienciaRepository;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExperienciaServiceImpl implements IExperienciaService{
    @Autowired
    private IExperienciaRepository experienciaRepository;

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private UsuarioService usuarioService;


    @Override
    @Transactional
    public List<Experiencia> findByIdPersona(Long idPersona) {
        var persona = this.personaRepository.findById(idPersona).get();

        return experienciaRepository.findByPersona(persona);
    }
    @Override
    @Transactional
    public Experiencia findById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Experiencia save(Experiencia experiencia) {
        experiencia.setPersona(this.usuarioService.getUsuarioLogueado().getPersona());

        return experienciaRepository.save(experiencia);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }

}
