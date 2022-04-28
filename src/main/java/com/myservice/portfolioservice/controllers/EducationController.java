package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Education;
import com.myservice.portfolioservice.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/education")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Education> list() {
        return educationRepository.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{id}")
    public Education get(@PathVariable Integer id) {
        return educationRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Education create(@RequestBody final Education education){
        return educationRepository.saveAndFlush(education);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        educationRepository.deleteById(id);
    }

}
