package com.portfolio.miportfolio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name= "hard_skills")
public class HardSkill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String Porcentaje;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        Porcentaje = porcentaje;
    }


    private static final long serialVersion = 1L;


}