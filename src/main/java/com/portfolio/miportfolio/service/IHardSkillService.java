package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.HardSkill;

import javax.transaction.Transactional;
import java.util.List;

public interface IHardSkillService {
    @Transactional
    List<HardSkill> findAll();

    public HardSkill findById(Long id);

    public HardSkill save (HardSkill hardSkill);

    public void delete (Long id);
}