package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.HardSkill;
import com.myservice.portfolioservice.repositories.HardSkillRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hardskill")
public class HardSkillController {
    @Autowired
    private HardSkillRepository hardSkillRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HardSkill> list() {
        return hardSkillRepository.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{id}")
    public HardSkill get(@PathVariable Integer id) {
        return hardSkillRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HardSkill create(@RequestBody final HardSkill hardSkill){
        return hardSkillRepository.saveAndFlush(hardSkill);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        hardSkillRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public HardSkill update(@PathVariable Integer id, @RequestBody HardSkill hardSkill) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400
        HardSkill existingHardSkill = hardSkillRepository.getById(id);
        BeanUtils.copyProperties(hardSkill, existingHardSkill, "id");
        return hardSkillRepository.saveAndFlush(existingHardSkill);
    }
}
