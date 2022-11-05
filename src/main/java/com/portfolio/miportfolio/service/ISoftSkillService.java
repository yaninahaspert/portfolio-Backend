package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.SoftSkill;

import javax.transaction.Transactional;
import java.util.List;

public interface ISoftSkillService {
    @Transactional
    List<SoftSkill> findAll();

    public SoftSkill findById(Long id);

    public SoftSkill save (SoftSkill softSkill);

    public void delete (Long id);
}