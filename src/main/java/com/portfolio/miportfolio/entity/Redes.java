package com.portfolio.miportfolio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "redes_sociales")
public class Redes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="nombre_red_social")
    private String nombreRedSocila;

    @Column (name="url_red_social")
    private String urlRedSocial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRedSocila() {
        return nombreRedSocila;
    }

    public void setNombreRedSocila(String nombreRedSocila) {
        this.nombreRedSocila = nombreRedSocila;
    }

    public String getUrlRedSocial() {
        return urlRedSocial;
    }

    public void setUrlRedSocial(String urlRedSocial) {
        this.urlRedSocial = urlRedSocial;
    }

    private static final long serialVersion = 1L;

}