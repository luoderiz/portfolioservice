package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.repositories.AboutRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
public class AboutController {
    @Autowired
    private AboutRepository aboutRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<About> list() {
        return aboutRepository.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{id}")
    public About get(@PathVariable Integer id) {
        return aboutRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public About create(@RequestBody final About about){
        return aboutRepository.saveAndFlush(about);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        aboutRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public About update(@PathVariable Integer id, @RequestBody About about) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400
        About existingAbout = aboutRepository.getById(id);
        BeanUtils.copyProperties(about, existingAbout, "id");
        return aboutRepository.saveAndFlush(existingAbout);
    }
}
