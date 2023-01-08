package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.service.IPersonaService;
import com.portfolio.miportfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PersonaRestController {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;

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
    public Persona create(@RequestBody Persona persona) {
        var usuarioLogueado = this.usuarioService.getUsuarioLogueado();

        if (usuarioLogueado == null || usuarioLogueado.getPersona() != null) {
            throw new AccessDeniedException("Acción no permitida");
        }

        persona.setUsuario(usuarioLogueado);

        return personaService.save(persona);
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona, @PathVariable Long id) {
        Persona personaAEditar = personaService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(personaAEditar.getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        personaAEditar.setDescripcionCompleta(persona.getDescripcionCompleta());
        personaAEditar.setNombre(persona.getNombre());
        personaAEditar.setProfesion(persona.getProfesion());
        personaAEditar.setDescripcionBreve(persona.getDescripcionBreve());

        return personaService.save(personaAEditar);
    }

    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getPersona().getId().equals(id)) {
            throw new AccessDeniedException("Acción no permitida");
        }

        personaService.delete(id);
    }
}
