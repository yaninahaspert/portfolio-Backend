package com.portfolio.miportfolio.service;
import com.portfolio.miportfolio.entity.Estudio;
import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.repository.IHardSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class HardSkillImpl implements IHardSkillService{
    @Autowired
    private IHardSkillRepository hardSkillRepository;

    @Override
    @Transactional
    public List<HardSkill> findAll() {
        return (List<HardSkill>) hardSkillRepository.findAll();
    }

    @Override
    @Transactional
    public HardSkill findById(Long id) {
        return hardSkillRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public HardSkill save(HardSkill hardSkill) {
        return hardSkillRepository.save(hardSkill);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        hardSkillRepository.deleteById(id);
    }

}
