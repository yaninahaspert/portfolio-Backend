package com.portfolio.miportfolio.entity;

import javax.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String asunto;

    private String email;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
    private Persona persona;

    public Contacto() {
    }

    public Contacto(String nombre, String asunto, String email, String descripcion, Persona persona) {
        this.nombre = nombre;
        this.asunto = asunto;
        this.email = email;
        this.descripcion = descripcion;
        this.persona = persona;
    }
}
