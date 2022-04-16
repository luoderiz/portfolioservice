package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.WorkExperience;
import com.myservice.portfolioservice.repositories.WorkExperienceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workexperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkExperience> list() {
        return workExperienceRepository.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{id}")
    public WorkExperience get(@PathVariable Integer id) {
        return workExperienceRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkExperience create(@RequestBody final WorkExperience workExperience){
        return workExperienceRepository.saveAndFlush(workExperience);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        workExperienceRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public WorkExperience update(@PathVariable Integer id, @RequestBody WorkExperience workExperience) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400
        WorkExperience existingWorkExperience = workExperienceRepository.getById(id);
        BeanUtils.copyProperties(workExperience, existingWorkExperience, "id");
        return workExperienceRepository.saveAndFlush(existingWorkExperience);
    }
}
