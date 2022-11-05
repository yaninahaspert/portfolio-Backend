package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.service.IHardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class HardSkillRestController {
    @Autowired
    private IHardSkillService hardSkillService;

    @GetMapping("/hardskills")
    public List<HardSkill> index() {
        return hardSkillService.findAll();
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

        hardSkill1Actual.setNombre(hardSkill.getNombre());
        hardSkill1Actual.setPorcentaje(hardSkill.getPorcentaje());

        return hardSkillService.save(hardSkill1Actual);
    }

    @DeleteMapping("/hardskills/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        hardSkillService.delete(id);
    }
}

