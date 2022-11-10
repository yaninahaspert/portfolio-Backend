package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.Experiencia;
import com.portfolio.miportfolio.entity.Proyecto;
import com.portfolio.miportfolio.entity.Redes;
import com.portfolio.miportfolio.service.IProyectoService;
import com.portfolio.miportfolio.service.IRedesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

        Redes redesActual = redesService.findById(id);

        redesActual.setNombreRedSocial(redes.getNombreRedSocial());
        redesActual.setUrlRedSocial(redes.getUrlRedSocial());

        return redesService.save(redesActual);
    }

    @DeleteMapping("/redes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        redesService.delete(id);
    }


}