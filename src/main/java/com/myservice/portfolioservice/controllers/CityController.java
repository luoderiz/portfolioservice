package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.City;
import com.myservice.portfolioservice.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<City> list() {
        return cityRepository.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestParam("city") String city) {
        City newCity = new City();
        newCity.setCity(city);
        return cityRepository.saveAndFlush(newCity);
    }

}
