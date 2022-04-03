package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Person get(@PathVariable Integer id) {
        return personRepository.getById(id);
    }
}
