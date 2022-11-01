package com.portfolio.miportfolio.controller;
import com.portfolio.miportfolio.entity.Estudios;
import com.portfolio.miportfolio.service.IEstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudiosRestController {
    @Autowired
    private IEstudiosService estudiosService;

    @GetMapping("/estudios")
    public List<Estudios> index() {
        return estudiosService.findAll();
    }

}
