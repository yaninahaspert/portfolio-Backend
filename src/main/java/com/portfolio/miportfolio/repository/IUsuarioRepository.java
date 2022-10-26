package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String usuario);

    public Usuario findTopByOrderByIdAsc();

    Boolean existsByNombreUsuario(String usuario);
    Boolean existsByEmail (String email);


}