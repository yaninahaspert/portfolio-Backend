package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
    public Usuario findTopByOrderByIdAsc();
}
