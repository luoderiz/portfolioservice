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

    /*
    @GetMapping("/{institution_id}")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    private Institution getInstitution(Integer institution_id){
        return institutionRepository.findById(institution_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la institución"));
    }

     */
//todo ver que pasa
    @PostMapping("/add")
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

    @RequestMapping(value = "/delete/{institution_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer institution_id) {
        institutionRepository.deleteById(institution_id);
    }

}
