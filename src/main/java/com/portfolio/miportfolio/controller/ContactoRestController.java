package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.dto.ContactoDTO;
import com.portfolio.miportfolio.entity.Contacto;
import com.portfolio.miportfolio.service.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactoRestController {

    @Autowired
    private IContactoService contactoService;

    @PostMapping("/contactos")
    @ResponseStatus(HttpStatus.CREATED)
    public Contacto create(@RequestBody ContactoDTO contactoDTO) {
        return contactoService.save(contactoDTO);
    }
}
