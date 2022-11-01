package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.HardSkill;
import com.portfolio.miportfolio.service.IHardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class HardSkillRestController {
    @Autowired
    private IHardSkillService hardSkillService;

    @GetMapping("/hardskills")
    public List<HardSkill> index() {
        return hardSkillService.findAll();
    }
}

