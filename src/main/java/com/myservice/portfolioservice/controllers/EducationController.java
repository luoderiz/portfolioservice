package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Education;
import com.myservice.portfolioservice.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/education")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @GetMapping
    public List<Education> list() {
        return educationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Education get(@PathVariable Integer id) {
        return educationRepository.getById(id);
    }

}
