package com.portfolio.miportfolio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "experiencias_laborales")
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date inicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fin;

    private String funciones;

    private String puesto;
    
    @Column(name = "url_logo")
    private String urlLogo;

    @Column(name= "es_trabajo_actual", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean esTrabajoActual;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Boolean getEsTrabajoActual() {
        return esTrabajoActual;
    }

    public void setEsTrabajoActual(Boolean esTrabajoActual) {
        this.esTrabajoActual = esTrabajoActual;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public boolean isEsTrabajoActual() {
        return esTrabajoActual;
    }

    public void setEsTrabajoActual(boolean esTrabajoActual) {
        this.esTrabajoActual = esTrabajoActual;
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
