package com.portfolio.miportfolio.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.portfolio.miportfolio.security.RolNombre;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private RolNombre rolNombre;

    //constructo vacio
    public Rol() {
    }

    //constructor
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
