package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Rol;
import com.portfolio.miportfolio.repository.IRolRepository;
import com.portfolio.miportfolio.security.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository rolRepository;

    public Optional <Rol> getByRolNombre (RolNombre rolnombre){
        return rolRepository.findByRolNombre(rolnombre);
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
