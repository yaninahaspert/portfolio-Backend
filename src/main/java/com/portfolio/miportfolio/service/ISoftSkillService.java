package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.SoftSkill;

import javax.transaction.Transactional;
import java.util.List;

public interface ISoftSkillService {
    @Transactional
    List<SoftSkill> findAll();
}