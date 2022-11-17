package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Redes;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import com.portfolio.miportfolio.repository.IRedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RedesReviceImpl implements IRedesService{
    @Autowired
    private IRedesRepository redesRepository;

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @Transactional
    public List<Redes> findByIdPersona(Long idPersona) {
        var persona = this.personaRepository.findById(idPersona).get();

        return redesRepository.findByPersona(persona);
    }
    @Override
    @Transactional
    public Redes findById(Long id) {
        return redesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Redes save(Redes redes) {
        redes.setPersona(this.usuarioService.getUsuarioLogueado().getPersona());

        return redesRepository.save(redes);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        redesRepository.deleteById(id);
    }
}

