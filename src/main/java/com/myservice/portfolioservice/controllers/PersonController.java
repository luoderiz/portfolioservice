package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.dto.PersonDto;
import com.myservice.portfolioservice.models.*;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public PersonDto getPerson(@PathVariable String username) {
        Person person = personRepository.findByUsername(username);
        String name =  person.getName();
        String surname = person.getSurname();
        String git = person.getGit();
        // String linkedin =
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setSurname(surname);
        personDto.setGit(git);
        personDto.setLinkedin("linkedin.luoderiz");
        return personDto;
    }
}