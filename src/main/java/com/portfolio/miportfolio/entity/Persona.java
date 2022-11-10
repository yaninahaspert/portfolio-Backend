package com.portfolio.miportfolio.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;

    private String profesion;

    @Column(name = "url_foto_perfl")
    private String urlFoto;


    @Column(name = "descripcion_breve")
    private String descripcionBreve;

    @Column(name = "url_imagen_presentacion")
    private String urlImagenPresentacion;

    @Size(min = 10)
    @Column(name = "descripcion_completa")
    private String descripcionCompleta;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "persona")
    private List<Estudio> listaEstudios;

    @OneToMany(mappedBy = "persona")
    private List<HardSkill> listaHardSkill;

    @OneToMany(mappedBy = "persona")
    private List<SoftSkill> listaSoftSkill;

    @OneToMany(mappedBy = "persona")
    private List<Experiencia> listaExperiencia;

    @OneToMany(mappedBy = "persona")
    private List<Redes> listaRedes;


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

    public String getDescripcionCompleta() {
        return descripcionCompleta;
    }

    public void setDescripcionCompleta(String descripcion) {
        this.descripcionCompleta = descripcion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setUrlImagenPresentacion(String urlImagenPresentacion) {
        this.urlImagenPresentacion = urlImagenPresentacion;
    }

    public String getUrlImagenPresentacion() {
        return urlImagenPresentacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void setListaRedes(List<Redes> listaRedes) {
        this.listaRedes = listaRedes;
    }

    public void setListaExperiencia(List<Experiencia> listaExperiencia) {
        this.listaExperiencia = listaExperiencia;
    }

    public void setListaSoftSkill(List<SoftSkill> listaSoftSkill) {
        this.listaSoftSkill = listaSoftSkill;
    }

    public void setListaEstudios(List<Estudio> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }

    public void setListaHardSkill(List<HardSkill> listaHardSkill) {
        this.listaHardSkill = listaHardSkill;
    }

    private static final long serialVersion = 1L;
}
