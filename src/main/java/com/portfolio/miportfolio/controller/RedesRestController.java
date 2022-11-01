package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.entity.Redes;
import com.portfolio.miportfolio.service.IEstudiosService;
import com.portfolio.miportfolio.service.IRedesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RedesRestController {
    @Autowired
    private IRedesService redesService;

    @GetMapping("/redes")
    public List<Redes> index() {
        return redesService.findAll();
    }

}