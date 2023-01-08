package com.portfolio.miportfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estudios")
public class Estudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_logo")
    private String urlLogo;

    private String titulo;

    @Column(name = "nombre_institucion")
    private String nombreInstitucion;

    private String direccion;

    private String telefono;

    private String ciudad;

    @Column(name = "sitio_web")
    private String sitioWeb;

    private String duracion;

    @Column(name = "ano_fin")
    private int anoFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getAnoFin() {
        return anoFin;
    }

    public void setAnoFin(int anoFin) {
        this.anoFin = anoFin;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @JsonIgnore()
    public Persona getPersona() {
        return persona;
    }
    public Long getIdPersona() {
        return this.getPersona().getId();
    }

    private static final long serialVersion = 1L;

}
