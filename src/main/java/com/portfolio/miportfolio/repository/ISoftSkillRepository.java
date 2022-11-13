package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.Persona;
import com.portfolio.miportfolio.entity.SoftSkill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISoftSkillRepository extends CrudRepository<SoftSkill, Long> {
    public List<SoftSkill> findByPersona(Persona persona);
}
