package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Education;
import com.myservice.portfolioservice.models.Institution;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.repositories.EducationRepository;
import com.myservice.portfolioservice.repositories.InstitutionRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.valueOf;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/education")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<Education> getAllEducation(@PathVariable String username) {
        Person person = personRepository.findByUsername(username);
        Integer id = person.getId();
        return educationRepository.findByPerson_id(id);
    }
/*

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Education create(@PathVariable String username, @RequestParam("degree") String degree,
    @RequestParam("date_from") String from,
    @RequestParam("date_to") String to,
    @RequestParam("institution_name") String institution,
        Person person = personRepository.findByUsername(username);
        Integer personId = person.getId();
        Education newEducation = new Education();
    // todo  retrieve dates from strings and institution from institution name
        newEducation.setDegree(degree);
    // todo    set todo lo otro
        newEducation.setPerson_id(personId);
        return aboutRepository.saveAndFlush(newAbout);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{education_id}")
    public Education getSpecificEducation(@PathVariable String username, @PathVariable Integer education_id) {
        return educationRepository.getById(education_id);
    }
*/  @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Education create(@PathVariable String username,
                          @RequestParam("degree") String degree,
                          @RequestParam("date_from") String date_from,
                          //todo ver que pide sí o sí todos los params, no acepta date null
                          @RequestParam("date_to") String date_to,
                          @RequestParam("institution_id") String institution_id) {
    Person person = personRepository.findByUsername(username);
    Integer personId = person.getId();
    java.sql.Date newEducationDateFrom = java.sql.Date.valueOf(date_from);
    java.sql.Date newEducationDateTo = java.sql.Date.valueOf(date_to);
    Integer newEducationInstitutionId = valueOf(institution_id);
    Institution newEducationInstitution = institutionRepository.findByInstitution_id(newEducationInstitutionId);
    Education newEducation = new Education();
    newEducation.setPerson_id(personId);
    newEducation.setDegree(degree);
    newEducation.setDate_from(newEducationDateFrom);
    newEducation.setDate_to(newEducationDateTo);
    newEducation.setInstitution(newEducationInstitution);
    return educationRepository.saveAndFlush(newEducation);
}


    @RequestMapping(value = "{education_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer education_id) {
        educationRepository.deleteById(education_id);
    }
}
