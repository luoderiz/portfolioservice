package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.*;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;


    // Todo: Ver permisos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getById(@PathVariable Integer id) {
        return getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody final Person person){
        return personRepository.saveAndFlush(person);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        personRepository.deleteById(id);
    }

    @GetMapping("/{id}/about")
    @ResponseStatus(HttpStatus.OK)
    public List<About> getAbouts(@PathVariable Integer id) {
        return getPerson(id).getAbout();
    }

    /*
    //ToDo: Preguntar si se pueden conservar las dos maneras de POST, de a uno y de a varios
    @PostMapping("/{id}/about")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addAbout(@PathVariable Integer id, @RequestBody final About about ) {
        Person person = getPerson(id);
        about.setPerson_id(id);
        person.addAbout(about);
        personRepository.saveAndFlush(person);
        return person;
    }
    */

    @PostMapping("/{id}/about")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addAbouts(@PathVariable Integer id, @RequestBody final List<About> abouts) {
        Person person = getPerson(id);
        for (About about: abouts) {
            about.setPerson_id(id);
            person.addAbout(about);
        }
        personRepository.saveAndFlush(person);
        return person;
    }

    @GetMapping("/{id}/softskill")
    @ResponseStatus(HttpStatus.OK)
    public List<SoftSkill> getSoftSkills(@PathVariable Integer id) {
        return getPerson(id).getSoftskill();
    }

    @PostMapping("/{id}/softskill")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addSoftSkills(@PathVariable Integer id, @RequestBody final List<SoftSkill> softSkills) {
        Person person = getPerson(id);
        for (SoftSkill softSkill: softSkills) {
            softSkill.setPerson_id(id);
            person.addSoftskill(softSkill);
        }
        personRepository.saveAndFlush(person);
        return person;
    }

    @GetMapping("/{id}/hardskill")
    @ResponseStatus(HttpStatus.OK)
    public List<HardSkill> getHardSkills(@PathVariable Integer id) {
        return getPerson(id).getHardskill();
    }

    @PostMapping("/{id}/hardskill")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addHardSkills(@PathVariable Integer id, @RequestBody final List<HardSkill> hardSkills) {
        Person person = getPerson(id);
        for (HardSkill hardSkill: hardSkills) {
            hardSkill.setPerson_id(id);
            person.addHardskill(hardSkill);
        }
        personRepository.saveAndFlush(person);
        return person;
    }

    @GetMapping("/{id}/education")
    @ResponseStatus(HttpStatus.OK)
    public  List<Education> getEducations(@PathVariable Integer id) {
        return getPerson(id).getEducation();
    }

    @PostMapping("/{id}/education")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addEducation(@PathVariable Integer id, @RequestBody final List<Education> educations) {
        Person person = getPerson(id);
        for (Education education: educations) {
            education.setPerson_id(id);
            person.addEducation(education);
        }
        personRepository.saveAndFlush(person);
        return person;
    }

    @GetMapping("/{id}/workexperience")
    @ResponseStatus(HttpStatus.OK)
    public List<WorkExperience> getWorkExperiences(@PathVariable Integer id) {
        return getPerson(id).getWorkexperience();
    }

    @PostMapping("/{id}/workexperience")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addWorkexperience(@PathVariable Integer id, @RequestBody final List<WorkExperience> workExperiences) {
        Person person = getPerson(id);
        for (WorkExperience workExperience: workExperiences){
            workExperience.setPerson_id(id);
            person.addWorkexperience(workExperience);
        }
        personRepository.saveAndFlush(person);
        return person;
    }

    @GetMapping("/{id}/project")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getProjects(@PathVariable Integer id) {
        return getPerson(id).getProjects();
    }

    @PostMapping("/{id}/project")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addProjects(@PathVariable Integer id, @RequestBody final List<Project> projects) {
        Person person = getPerson(id);
        for (Project project: projects){
            project.setPerson_id(id);
            person.addProjects(project);
        }
        personRepository.saveAndFlush(person);
        return person;
    }

    private Person getPerson(Integer id){
        return personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la persona"));
    }
}
