package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Institution;
import com.myservice.portfolioservice.repositories.InstitutionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institution")
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Institution> list() {
        return institutionRepository.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{id}")
    public Institution get(@PathVariable Integer id) {
        return institutionRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Institution create(@RequestBody final Institution institution){
        return institutionRepository.saveAndFlush(institution);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        institutionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Institution update(@PathVariable Integer id, @RequestBody Institution institution) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400
        Institution existingInstitution = institutionRepository.getById(id);
        BeanUtils.copyProperties(institution, existingInstitution, "id");
        return institutionRepository.saveAndFlush(existingInstitution);
    }

}
