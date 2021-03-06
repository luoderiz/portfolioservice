package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.HardSkill;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.SoftSkill;
import com.myservice.portfolioservice.repositories.HardSkillRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public HardSkill create(@PathVariable String username, @RequestParam("skill") String skill){
        Person person = personRepository.findByUsername(username);
        Integer personId = person.getId();
        HardSkill newHardSkill = new HardSkill();
        newHardSkill.setSkill(skill);
        newHardSkill.setPerson_id(personId);
        return hardSkillRepository.saveAndFlush(newHardSkill);
    }

    @PatchMapping("/{skill_id}")
    public HardSkill update(@RequestParam("skill") Optional<String> skill,
                            @PathVariable("skill_id") Integer skill_id){
        HardSkill hardSkillToUpdate = hardSkillRepository.getById(skill_id);
        skill.ifPresent(hardSkillToUpdate::setSkill);
        return hardSkillRepository.saveAndFlush(hardSkillToUpdate);
    }

    @RequestMapping(value = "/{skill_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer skill_id) {
        hardSkillRepository.deleteById(skill_id);
    }

}
