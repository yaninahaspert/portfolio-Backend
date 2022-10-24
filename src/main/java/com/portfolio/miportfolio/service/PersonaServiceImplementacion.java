package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import com.portfolio.miportfolio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PersonaServiceImplementacion implements IPersonaService{
    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public List<Persona> findAll() {
        return (List <Persona>) personaRepository.findAll();
    }

    @Override
    @Transactional
    public Persona findById (Long id){
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save (Persona persona){
        var usuario = this.usuarioRepository.findTopByOrderByIdAsc();

        persona.setUsuario(usuario);

        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id){
        personaRepository.deleteById(id);
    }

}
