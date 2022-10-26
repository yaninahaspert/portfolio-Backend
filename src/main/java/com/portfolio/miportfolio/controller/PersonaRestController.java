package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import com.portfolio.miportfolio.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PersonaRestController {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPersonaRepository personaRepository;
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/personas")
    public List<Persona> index() {
        return personaService.findAll();
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/personas/{id}")
    public Persona show(@PathVariable Long id) {
        return personaService.findById(id);
    }
@PreAuthorize("hasRole('USER')")
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
    @PreAuthorize("hasRole('USER')")
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
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }
}
