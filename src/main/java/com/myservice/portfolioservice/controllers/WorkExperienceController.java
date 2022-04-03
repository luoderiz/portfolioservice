package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.WorkExperience;
import com.myservice.portfolioservice.repositories.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workexperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @GetMapping
    public List<WorkExperience> list() {
        return workExperienceRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public WorkExperience get(@PathVariable Integer id) {
        return workExperienceRepository.getById(id);
    }
}
