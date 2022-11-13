package com.portfolio.miportfolio.service;
import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.repository.IHardSkillRepository;
import com.portfolio.miportfolio.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class HardSkillImpl implements IHardSkillService{
    @Autowired
    private IHardSkillRepository hardSkillRepository;

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @Transactional
    public List<HardSkill> findByIdPersona(Long idPersona) {
        var persona = this.personaRepository.findById(idPersona).get();

        return hardSkillRepository.findByPersona(persona);
    }

    @Override
    @Transactional
    public HardSkill findById(Long id) {
        return hardSkillRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public HardSkill save(HardSkill hardSkill) {
        hardSkill.setPersona(this.usuarioService.getUsuarioLogueado().getPersona());
        return hardSkillRepository.save(hardSkill);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        hardSkillRepository.deleteById(id);
    }

}
