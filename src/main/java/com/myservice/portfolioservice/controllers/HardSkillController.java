package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.HardSkill;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.repositories.HardSkillRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
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

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<HardSkill> getAllHardSkill(@PathVariable String username) {
        Person person = personRepository.findByUsername(username);
        Integer id = person.getId();
        return hardSkillRepository.findByPerson_id(id);
    }
/*
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{hardskill_id}")
    public HardSkill getSpecificHardSkill(@PathVariable String username, @PathVariable Integer hardskill_id) {
        return hardSkillRepository.getById(hardskill_id);
    }
*/
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
