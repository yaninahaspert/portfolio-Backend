package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import com.portfolio.miportfolio.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PersonaRestController {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> index() {
        return personaService.findAll();
    }

    @GetMapping("/personas/{id}")
    public Persona show(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona create(@RequestBody Persona personaDTO) {
        var personaPrevia = this.personaRepository.findTopByOrderByIdAsc();

        Persona personaAGuardar;
        if (personaPrevia == null) {
            personaAGuardar = personaDTO;
        } else {
            personaAGuardar = personaPrevia;
            personaAGuardar.setDescripcionCompleta(personaDTO.getDescripcionCompleta());
            personaAGuardar.setNombre(personaDTO.getNombre());
            personaAGuardar.setProfesion(personaDTO.getProfesion());
            personaAGuardar.setDescripcionBreve(personaDTO.getDescripcionBreve());
        }

        return personaService.save(personaAGuardar);
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona, @PathVariable Long id) {
        Persona personaActual = personaService.findById(id);

        personaActual.setDescripcionCompleta(persona.getDescripcionCompleta());
        personaActual.setNombre(persona.getNombre());
        personaActual.setProfesion(persona.getProfesion());
        personaActual.setDescripcionBreve(persona.getDescripcionBreve());

        return personaService.save(personaActual);
    }

    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }
}
