package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Project;
import com.myservice.portfolioservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> list() {
        return projectRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project get(@PathVariable Integer id) {
        return projectRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody final Project project){
        return projectRepository.saveAndFlush(project);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        projectRepository.deleteById(id);
    }

}
