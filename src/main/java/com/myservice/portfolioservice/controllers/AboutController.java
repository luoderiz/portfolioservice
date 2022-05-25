package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.Project;
import com.myservice.portfolioservice.repositories.AboutRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PatchMapping("/{about_id}")
    public About update(@RequestParam ("about") Optional<String> about,
                        @PathVariable("about_id") Integer about_id){
        About aboutToUpdate = aboutRepository.getById(about_id);
        about.ifPresent(aboutToUpdate::setAbout);
        return aboutRepository.saveAndFlush(aboutToUpdate);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public About create(@PathVariable String username, @RequestParam("about") String about){
        Person person = personRepository.findByUsername(username);
        Integer personId = person.getId();
        About newAbout = new About();
        newAbout.setAbout(about);
        newAbout.setPerson_id(personId);
        return aboutRepository.saveAndFlush(newAbout);
    }

    @RequestMapping(value = "/{about_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Integer about_id) {
        aboutRepository.deleteById(about_id);
    }

}
