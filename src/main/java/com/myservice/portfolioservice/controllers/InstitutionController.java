package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.City;
import com.myservice.portfolioservice.models.Institution;
import com.myservice.portfolioservice.repositories.CityRepository;
import com.myservice.portfolioservice.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/institution")
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Institution> list() {
        return institutionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Institution create(
                          @RequestParam("institution") String institution,
                          @RequestParam("city_id") Integer city_id) {
        City city = cityRepository.findByCity_Id(city_id);
        Institution newInstitution = new Institution();
        newInstitution.setInstitution(institution);
        newInstitution.setCity(city);
        return institutionRepository.saveAndFlush(newInstitution);
    }

}
