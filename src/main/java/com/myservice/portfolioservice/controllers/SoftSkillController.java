package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.SoftSkill;
import com.myservice.portfolioservice.repositories.PersonRepository;
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

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<SoftSkill> getAllSoftSkill(@PathVariable String username) {
        Person person= personRepository.findByUsername(username);
        Integer id = person.getId();
        return softSkillRepository.findByPerson_id(id);
    }
/*
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{softskill_id}")
        public SoftSkill getSpecificSoftSkill(@PathVariable String username, @PathVariable Integer softskill_id) {
        return softSkillRepository.getById(softskill_id);
    }
*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoftSkill create(@RequestBody final SoftSkill softSkill) {
        return softSkillRepository.saveAndFlush(softSkill);
    }

    @RequestMapping(value = "{softskill_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        softSkillRepository.deleteById(id);
    }

}
