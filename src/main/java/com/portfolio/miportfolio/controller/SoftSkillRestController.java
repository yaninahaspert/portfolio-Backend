package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.SoftSkill;
import com.portfolio.miportfolio.service.ISoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class SoftSkillRestController {
    @Autowired
    private ISoftSkillService softskillService;

    @GetMapping("/softskills")
    public List<SoftSkill> index(@RequestParam(name = "id_persona", required = true) String idPersona) {
        return softskillService.findByIdPersona(Long.parseLong(idPersona));
    }


    @GetMapping("/softskills/{id}")
    public SoftSkill show(@PathVariable Long id) {
        return softskillService.findById(id);
    }

    @PostMapping("/softskills")
    @ResponseStatus(HttpStatus.CREATED)
    public SoftSkill create(@RequestBody SoftSkill softSkill) {
        return softskillService.save(softSkill);
    }

    @PutMapping("/softskills/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public SoftSkill update(@RequestBody SoftSkill softSkill, @PathVariable Long id) {

        SoftSkill softSkill1Actual = softskillService.findById(id);

        softSkill1Actual.setNombre(softSkill.getNombre());
        softSkill1Actual.setPorcentaje(softSkill.getPorcentaje());

        return softskillService.save(softSkill1Actual);
    }

    @DeleteMapping("/softskills/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        softskillService.delete(id);
    }

}