package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.service.IProyectoService;
import com.portfolio.miportfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProyectoRestController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/proyectos")
    public List<Proyecto> index(@RequestParam(name = "id_persona", required = true) String idPersona) {
        return proyectoService.findByIdPersona(Long.parseLong(idPersona));
    }

    @GetMapping("/proyectos/{id}")
    public Proyecto show(@PathVariable Long id) {
        return proyectoService.findById(id);
    }

    @PostMapping("/proyectos")
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto create(@RequestBody Proyecto proyecto) {
        return proyectoService.save(proyecto);
    }

    @PutMapping("/proyectos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto update(@RequestBody Proyecto proyecto, @PathVariable Long id) {

        Proyecto proyectoActual = proyectoService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(proyectoActual.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        proyectoActual.setNombre(proyecto.getNombre());
        proyectoActual.setDescripcion(proyecto.getDescripcion());
        proyectoActual.setUrl(proyecto.getUrl());
        proyectoActual.setUrlImagen(proyecto.getUrlImagen());

        return proyectoService.save(proyectoActual);
    }

    @DeleteMapping("/proyectos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        Proyecto proyectoAEliminar = proyectoService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(proyectoAEliminar.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }
        proyectoService.delete(id);
    }

}