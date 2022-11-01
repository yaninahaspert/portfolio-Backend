package com.portfolio.miportfolio.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String nombre;

    @NotNull
    @Column(name = "usuario")
    private String nombreUsuario;

    @NotNull
    private String email;

    @NotNull
    @Column(name = "contrasena")
    private String password;

    //relacion tabla persona
    @OneToOne(mappedBy = "usuario")
    private Persona persona;

    //relacion tabla rol
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    //union de las dos tablas
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuarios", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_roles", referencedColumnName = "id"))
    private List<Rol> roles = new ArrayList<>();

    //constructor vacio
    public Usuario() {
    }
//constructor

    public Usuario(String nombre, String usuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = usuario;
        this.email = email;
        this.password = password;
    }
    //getter and setter


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String username) {
        this.nombre = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void addRole(Rol rol) {
        this.roles.add(rol);
    }

    private static final long serialVersion = 1L;

}
