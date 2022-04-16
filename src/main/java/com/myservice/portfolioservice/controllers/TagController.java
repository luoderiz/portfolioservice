package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.models.Tag;
import com.myservice.portfolioservice.repositories.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tag> list() {
        return tagRepository.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{id}")
    public Tag get(@PathVariable Integer id) {
        return tagRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag create(@RequestBody final Tag tag){
        return tagRepository.saveAndFlush(tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        tagRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Tag update(@PathVariable Integer id, @RequestBody Tag tag) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400
        Tag existingTag = tagRepository.getById(id);
        BeanUtils.copyProperties(tag, existingTag, "id");
        return tagRepository.saveAndFlush(existingTag);
    }

}
