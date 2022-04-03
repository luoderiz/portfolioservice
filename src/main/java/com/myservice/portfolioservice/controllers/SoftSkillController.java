package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.models.SoftSkill;
import com.myservice.portfolioservice.repositories.AboutRepository;
import com.myservice.portfolioservice.repositories.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/softskill")
public class SoftSkillController {
    @Autowired
    private SoftSkillRepository softSkillRepository;

    @GetMapping
    public List<SoftSkill> list() {
        return softSkillRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SoftSkill get(@PathVariable Integer id) {
        return softSkillRepository.getById(id);
    }
}
