package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.SoftSkill;
import com.myservice.portfolioservice.repositories.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/softskill")
public class SoftSkillController {
    @Autowired
    private SoftSkillRepository softSkillRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SoftSkill> list() {
        return softSkillRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public SoftSkill get(@PathVariable Integer id) {
        return softSkillRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoftSkill create(@RequestBody final SoftSkill softSkill){
        return softSkillRepository.saveAndFlush(softSkill);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        softSkillRepository.deleteById(id);
    }

}
