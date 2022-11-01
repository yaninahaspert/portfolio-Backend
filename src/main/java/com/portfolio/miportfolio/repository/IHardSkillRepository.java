package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.entity.HardSkill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHardSkillRepository extends CrudRepository<HardSkill, Long> {
    public List<HardSkill> findAll();
}