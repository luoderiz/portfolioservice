package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Education;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.repositories.EducationRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/education")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<Education> getAllEducation(@PathVariable String username) {
        Person person = personRepository.findByUsername(username);
        Integer id = person.getId();
        return educationRepository.findByPerson_id(id);
    }
/*
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{education_id}")
    public Education getSpecificEducation(@PathVariable String username, @PathVariable Integer education_id) {
        return educationRepository.getById(education_id);
    }
*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Education create(@RequestBody final Education education){
        return educationRepository.saveAndFlush(education);
    }

    @RequestMapping(value = "{education_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        educationRepository.deleteById(id);
    }

}
