package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.repositories.AboutRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/about")
public class AboutController {
    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<About> getAllAbout(@PathVariable String username) {
        Person person = personRepository.findByUsername(username);
        Integer id = person.getId();
        return aboutRepository.findByPerson_id(id);
    }
/*
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{about_id}")
    public About getSpecificAbout(@PathVariable String username, @PathVariable Integer about_id) {
       return aboutRepository.getById(about_id);
    }
*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public About create(@RequestBody final About about){
        return aboutRepository.saveAndFlush(about);
    }

    @RequestMapping(value = "{about_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        aboutRepository.deleteById(id);
    }

}
