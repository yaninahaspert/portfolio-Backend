package com.portfolio.miportfolio.dto;

public class PersonaDTO {
    private String nombre;
    private String profesion;
    private String urlFoto;
    private String descripcionBreve;
    private String urlImagenPresentacion;
    private String descripcionCompleta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getUrlImagenPresentacion() {
        return urlImagenPresentacion;
    }

    public void setUrlImagenPresentacion(String urlImagenPresentacion) {
        this.urlImagenPresentacion = urlImagenPresentacion;
    }

    public String getDescripcionCompleta() {
        return descripcionCompleta;
    }

    public void setDescripcionCompleta(String descripcionCompleta) {
        this.descripcionCompleta = descripcionCompleta;
    }
}
