package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.entity.SoftSkill;
import com.portfolio.miportfolio.service.ISoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class SoftSkillRestController {
    @Autowired
    private ISoftSkillService softskillService;

    @GetMapping("/softskills")
    public List<SoftSkill> index() {
        return softskillService.findAll();
    }

}