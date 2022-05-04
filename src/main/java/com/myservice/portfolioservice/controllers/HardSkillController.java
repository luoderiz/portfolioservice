package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.HardSkill;
import com.myservice.portfolioservice.repositories.HardSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/hardskill")
public class HardSkillController {
    @Autowired
    private HardSkillRepository hardSkillRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public HardSkill get(@PathVariable Integer id) {
        return hardSkillRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HardSkill create(@RequestBody final HardSkill hardSkill){
        return hardSkillRepository.saveAndFlush(hardSkill);
    }

    @RequestMapping(value = "{hardskill_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        hardSkillRepository.deleteById(id);
    }

}
