package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.service.IEstudiosService;
import com.portfolio.miportfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudiosRestController {
    @Autowired
    private IEstudiosService estudiosService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/estudios")
    public List<Estudio> index(@RequestParam(name = "id_persona", required = true) String idPersona) {
        return estudiosService.findByIdPersona(Long.parseLong(idPersona));
    }

    @GetMapping("/estudios/{id}")
    public Estudio show(@PathVariable Long id) {
        return estudiosService.findById(id);
    }

    @PostMapping("/estudios")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudio create(@RequestBody Estudio estudio) {
        return estudiosService.save(estudio);
    }

    @PutMapping("/estudios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudio update(@RequestBody Estudio estudio, @PathVariable Long id) {
        Estudio estudioActual = estudiosService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(estudioActual.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        estudioActual.setCiudad(estudio.getCiudad());
        estudioActual.setDireccion(estudio.getDireccion());
        estudioActual.setAnoFin(estudio.getAnoFin());
        estudioActual.setDuracion(estudio.getDuracion());
        estudioActual.setTelefono(estudio.getTelefono());
        estudioActual.setNombreInstitucion(estudio.getNombreInstitucion());
        estudioActual.setTitulo(estudio.getTitulo());
        estudioActual.setSitioWeb(estudio.getSitioWeb());
        estudioActual.setUrlLogo(estudio.getUrlLogo());

        return estudiosService.save(estudioActual);
    }

    @DeleteMapping("/estudios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Estudio estudioAEliminar = estudiosService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(estudioAEliminar.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        estudiosService.delete(id);
    }
}

