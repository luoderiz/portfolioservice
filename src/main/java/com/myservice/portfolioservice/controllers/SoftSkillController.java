package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.SoftSkill;
import com.myservice.portfolioservice.repositories.PersonRepository;
import com.myservice.portfolioservice.repositories.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping("{skill_id}")
        public SoftSkill getSpecificSoftSkill(@PathVariable String username, @PathVariable Integer softskill_id) {
        return softSkillRepository.getById(softskill_id);
    }
*/

    @PatchMapping("/{skill_id}")
    public SoftSkill update(@RequestParam("skill") Optional<String> skill,
                        @PathVariable("skill_id") Integer skill_id){
        SoftSkill softSkillToUpdate = softSkillRepository.getById(skill_id);
        skill.ifPresent(softSkillToUpdate::setSkill);
        return softSkillRepository.saveAndFlush(softSkillToUpdate);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoftSkill create(@PathVariable String username, @RequestParam("skill") String skill) {
        Person person = personRepository.findByUsername(username);
        Integer personId = person.getId();
        SoftSkill newSoftSkill = new SoftSkill();
        newSoftSkill.setPerson_id(personId);
        newSoftSkill.setSkill(skill);
        return softSkillRepository.saveAndFlush(newSoftSkill);
    }

    @RequestMapping(value = "/{skill_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer skill_id) {
        softSkillRepository.deleteById(skill_id);
    }

}
