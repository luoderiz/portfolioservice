package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.WorkExperience;
import com.myservice.portfolioservice.repositories.PersonRepository;
import com.myservice.portfolioservice.repositories.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/workexperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<WorkExperience> getAllWorkexperience(@PathVariable String username) {
        Person person= personRepository.findByUsername(username);
        Integer id = person.getId();
        return workExperienceRepository.findByPerson_id(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkExperience create(@RequestBody final WorkExperience workExperience){
        return workExperienceRepository.saveAndFlush(workExperience);
    }

    @RequestMapping(value = "{workexperience_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        workExperienceRepository.deleteById(id);
    }
}
