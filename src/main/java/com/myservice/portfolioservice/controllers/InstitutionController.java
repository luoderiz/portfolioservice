package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Institution;
import com.myservice.portfolioservice.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/institution")
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
    @RequestMapping("/{id}")
    public Institution getById(@PathVariable Integer id) {
        return getInstitution(id);
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

    private Institution getInstitution(Integer id){
        return institutionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la institución"));
    }
}
