package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.entity.Redes;
import com.portfolio.miportfolio.service.IProyectoService;
import com.portfolio.miportfolio.service.IRedesService;
import com.portfolio.miportfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RedesRestController {
    @Autowired
    private IRedesService redesService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/redes")
    public List<Redes> index(@RequestParam(name = "id_persona", required = true) String idPersona) {
        return redesService.findByIdPersona(Long.parseLong(idPersona));
    }

    @PostMapping("/redes")
    @ResponseStatus(HttpStatus.CREATED)
    public Redes create(@RequestBody Redes redes) {
        return redesService.save(redes);
    }


    @GetMapping("/redes/{id}")
    public Redes show(@PathVariable Long id) {
        return redesService.findById(id);
    }


    @PutMapping("/redes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Redes update(@RequestBody Redes redes, @PathVariable Long id) {
        Redes redAEditar = redesService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(redAEditar.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        redAEditar.setNombreRedSocial(redes.getNombreRedSocial());
        redAEditar.setUrlRedSocial(redes.getUrlRedSocial());

        return redesService.save(redAEditar);
    }

    @DeleteMapping("/redes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var redAEliminar = redesService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(redAEliminar.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        redesService.delete(id);
    }


}