package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.entity.SoftSkill;
import com.portfolio.miportfolio.repository.ISoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class SoftSkillServiceImpl implements ISoftSkillService{
    @Autowired
    private ISoftSkillRepository softSkillRepository;

    @Override
    @Transactional
    public List<SoftSkill> findAll() {
        return (List<SoftSkill>) softSkillRepository.findAll();
    }
}
