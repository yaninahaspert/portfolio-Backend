package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.entity.Estudio;
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

    @Override
    @Transactional
    public SoftSkill findById(Long id) {
        return softSkillRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public SoftSkill save(SoftSkill softSkill) {
        return softSkillRepository.save(softSkill);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        softSkillRepository.deleteById(id);
    }
}
