package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.repositories.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about")
public class AboutController {
    @Autowired
    private AboutRepository aboutRepository;

    @GetMapping
    public List<About> list() {
        return aboutRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public About get(@PathVariable Integer id) {
        return aboutRepository.getById(id);
    }
}
