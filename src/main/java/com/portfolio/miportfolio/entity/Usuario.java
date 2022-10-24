package com.portfolio.miportfolio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String contrasena;

    public Long getId() {
        return id;
    }

    @OneToOne(mappedBy = "usuario")
    private Persona persona;
}

