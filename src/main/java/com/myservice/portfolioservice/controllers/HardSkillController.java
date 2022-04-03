package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.HardSkill;
import com.myservice.portfolioservice.repositories.HardSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hardskill")
public class HardSkillController {
    @Autowired
    private HardSkillRepository hardSkillRepository;

    @GetMapping
    public List<HardSkill> list() {
        return hardSkillRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public HardSkill get(@PathVariable Integer id) {
        return hardSkillRepository.getById(id);
    }
}
