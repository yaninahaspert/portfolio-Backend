package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.service.IEstudiosService;
import com.portfolio.miportfolio.service.IHardSkillService;
import com.portfolio.miportfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class HardSkillRestController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IHardSkillService hardSkillService;

    @GetMapping("/hardskills")
    public List<HardSkill> index(@RequestParam(name = "id_persona", required = true) String idPersona) {
        return hardSkillService.findByIdPersona(Long.parseLong(idPersona));
    }

    @GetMapping("/hardskills/{id}")
    public HardSkill show(@PathVariable Long id) {
        return hardSkillService.findById(id);
    }

    @PostMapping("/hardskills")
    @ResponseStatus(HttpStatus.CREATED)
    public HardSkill create(@RequestBody HardSkill hardSkill) {
        return hardSkillService.save(hardSkill);
    }

    @PutMapping("/hardskills/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HardSkill update(@RequestBody HardSkill hardSkill, @PathVariable Long id) {

        HardSkill hardSkill1Actual = hardSkillService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(hardSkill1Actual.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }

        hardSkill1Actual.setNombre(hardSkill.getNombre());
        hardSkill1Actual.setPorcentaje(hardSkill.getPorcentaje());

        return hardSkillService.save(hardSkill1Actual);
    }

    @DeleteMapping("/hardskills/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        HardSkill hardSkillAEliminar = hardSkillService.findById(id);

        var usuarioActual = this.usuarioService.getUsuarioLogueado();
        if (usuarioActual == null || ! usuarioActual.getId().equals(hardSkillAEliminar.getPersona().getUsuario().getId())) {
            throw new AccessDeniedException("Acción no permitida");
        }
        hardSkillService.delete(id);
    }
}

