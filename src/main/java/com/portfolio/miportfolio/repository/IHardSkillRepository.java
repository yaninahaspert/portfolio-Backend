package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.entity.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHardSkillRepository extends CrudRepository<HardSkill, Long> {
    public List<HardSkill> findByPersona(Persona persona);
}