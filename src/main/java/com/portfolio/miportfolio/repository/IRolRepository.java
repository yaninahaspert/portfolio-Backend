package com.portfolio.miportfolio.repository;

import aj.org.objectweb.asm.Opcodes;
import com.portfolio.miportfolio.entity.Rol;
import com.portfolio.miportfolio.security.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository <Rol,Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
