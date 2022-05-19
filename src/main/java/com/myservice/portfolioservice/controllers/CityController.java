package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.City;
import com.myservice.portfolioservice.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

/*
    @GetMapping("/{city_id}")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    private City getCity(Integer city_id){
        return cityRepository.findByCity_Id(city_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la ciudad"));
    }
*/


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestParam("city") String city) {
        City newCity = new City();
        newCity.setCity(city);
        return cityRepository.saveAndFlush(newCity);
    }


    @RequestMapping(value = "/delete/{city_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer city_id) {
        cityRepository.deleteById(city_id);
    }


}
