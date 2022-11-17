package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.dto.ContactoDTO;
import com.portfolio.miportfolio.entity.Contacto;

public interface IContactoService {
    public Contacto save (ContactoDTO contacto);
}
