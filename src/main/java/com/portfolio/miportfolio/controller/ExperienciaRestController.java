package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.service.IExperienciaService;
import com.portfolio.miportfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExperienciaRestController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IExperienciaService experienciaService;

    @GetMapping("/experiencias")
    public List<Experiencia> index(@RequestParam(name = "id_persona", required = true) String idPersona) {
        return experienciaService.findByIdPersona(Long.parseLong(idPersona));
    }
    @GetMapping("/experiencias/{id}")
    public Experiencia show(@PathVariable Long id) {
        return experienciaService.findById(id);
    }

    @PostMapping("/experiencias")
    @ResponseStatus(HttpStatus.CREATED)
    public Experiencia create(@RequestBody Experiencia experiencia) {
        return experienciaService.save(experiencia);
    }

    @PutMapping("/experiencias/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Experiencia update(@RequestBody Experiencia experiencia, @PathVariable Long id) {

        Experiencia experienciaActual = experienciaService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(experienciaActual.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        experienciaActual.setEmpresa((experiencia.getEmpresa()));
        experienciaActual.setInicio(experiencia.getInicio());
        experienciaActual.setFin(experiencia.getFin());
        experienciaActual.setFunciones(experiencia.getFunciones());
        experienciaActual.setPuesto(experiencia.getPuesto());
        experienciaActual.setEsTrabajoActual(experiencia.getEsTrabajoActual());


        return experienciaService.save(experienciaActual);
    }

    @DeleteMapping("/experiencias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        Experiencia experienciaAEliminar = experienciaService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(experienciaAEliminar.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }
        experienciaService.delete(id);
    }

}