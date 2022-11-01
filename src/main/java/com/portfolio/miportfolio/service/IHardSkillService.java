package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.HardSkill;

import javax.transaction.Transactional;
import java.util.List;

public interface IHardSkillService {
    @Transactional
    List<HardSkill> findAll();
}