package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.SoftSkill;
import com.myservice.portfolioservice.repositories.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/softskill")
public class SoftSkillController {
    @Autowired
    private SoftSkillRepository softSkillRepository;

    @GetMapping
    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public SoftSkill get(@PathVariable Integer id) {
        return softSkillRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoftSkill create(@RequestBody final SoftSkill softSkill){
        return softSkillRepository.saveAndFlush(softSkill);
    }

    @RequestMapping(value = "{softskill_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        softSkillRepository.deleteById(id);
    }

}
