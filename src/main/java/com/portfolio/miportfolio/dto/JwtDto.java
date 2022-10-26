package com.portfolio.miportfolio.dto;

import org.springframework.security.core.GrantedAuthority;

import java.awt.*;
import java.util.Collection;

public class JwtDto {
    private String token;
    private String beader="Beader";
    private String nombreUsuario;
    private Collection <? extends GrantedAuthority> authorities;

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBeader() {
        return beader;
    }

    public void setBeader(String beader) {
        this.beader = beader;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}



