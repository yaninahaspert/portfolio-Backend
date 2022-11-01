package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.service.IEstudiosService;
import com.portfolio.miportfolio.service.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExperienciaRestController {
    @Autowired
    private IExperienciaService experienciaService;

    @GetMapping("/experiencias")
    public List<Experiencia> index() {
        return experienciaService.findAll();
    }

}