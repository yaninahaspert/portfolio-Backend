package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.dto.ContactoDTO;
import com.portfolio.miportfolio.entity.Contacto;
import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.repository.IContactoRepository;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ContactoServiceImpl implements IContactoService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private IContactoRepository contactoRepository;

    @Override
    @Transactional
    public Contacto save(ContactoDTO contactoDTO) {
        Persona persona = this.personaRepository.findById(contactoDTO.getId_persona()).get();

        Contacto contacto = new Contacto(
            contactoDTO.getNombre(),
            contactoDTO.getAsunto(),
            contactoDTO.getEmail(),
            contactoDTO.getDescripcion(),
            persona
        );

        return contactoRepository.save(contacto);
    }
}
