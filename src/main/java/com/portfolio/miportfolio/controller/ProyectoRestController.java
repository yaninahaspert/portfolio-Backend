package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.service.IEstudiosService;
import com.portfolio.miportfolio.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProyectoRestController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/proyectos")
    public List<Proyecto> index() {
        return proyectoService.findAll();
    }

}