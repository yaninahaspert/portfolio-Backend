package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Usuario;
import com.portfolio.miportfolio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Boolean existsByNombreUsuario(String nombreUsuario){
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    public Boolean existsByEmail(String email){
        return iUsuarioRepository.existsByEmail(email);
    }
    public void save (Usuario usuario){
        iUsuarioRepository.save(usuario);
    }

}

