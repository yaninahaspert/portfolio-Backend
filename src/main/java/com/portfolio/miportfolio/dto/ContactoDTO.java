package com.portfolio.miportfolio.dto;

import java.io.Serializable;

public class ContactoDTO implements Serializable  {
    private static final long serialVersion = 1L;

    private String nombre;

    private String asunto;

    private String email;

    private String descripcion;

    private Long id_persona;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public Long getId_persona() {
        return id_persona;
    }
}
