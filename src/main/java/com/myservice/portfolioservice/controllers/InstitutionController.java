package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Institution;
import com.myservice.portfolioservice.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institution")
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping
    public List<Institution> list() {
        return institutionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Institution get(@PathVariable Integer id) {
        return institutionRepository.getById(id);
    }

}
