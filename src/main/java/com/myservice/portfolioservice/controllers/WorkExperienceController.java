package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Education;
import com.myservice.portfolioservice.models.Institution;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.WorkExperience;
import com.myservice.portfolioservice.repositories.InstitutionRepository;
import com.myservice.portfolioservice.repositories.PersonRepository;
import com.myservice.portfolioservice.repositories.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.valueOf;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/workexperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<WorkExperience> getAllWorkexperience(@PathVariable String username) {
        Person person= personRepository.findByUsername(username);
        Integer id = person.getId();
        return workExperienceRepository.findByPerson_id(id);
    }

    /*
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("{workexperience_id}")
    public WorkExperience getSpecificWorkexperience(@PathVariable String username, @PathVariable Integer workexperience_id) {
        return workExperienceRepository.getById(workexperience_id);
    }
*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkExperience create(@PathVariable String username,
                                 @RequestParam("position") String position,
                                 @RequestParam("date_from") String date_from,
                                 @RequestParam("date_to") String date_to,
                                 @RequestParam("details") String details,
                                 @RequestParam("institution_id") String institution_id) {
        Person person = personRepository.findByUsername(username);
        Integer personId = person.getId();
        java.sql.Date newWorkExperienceDateFrom = java.sql.Date.valueOf(date_from);
        java.sql.Date newWorkExperienceDateTo = java.sql.Date.valueOf(date_to);
        Integer newWorkExperienceInstitutionId = valueOf(institution_id);
        Institution newWorkExperienceInstitution = institutionRepository.findByInstitution_id(newWorkExperienceInstitutionId);
        WorkExperience newWorkExperience = new WorkExperience();
        newWorkExperience.setPerson_id(personId);
        newWorkExperience.setPosition(position);
        newWorkExperience.setDate_from(newWorkExperienceDateFrom);
        newWorkExperience.setDate_to(newWorkExperienceDateTo);
        newWorkExperience.setDetails(details);
        newWorkExperience.setInstitution(newWorkExperienceInstitution);
        return workExperienceRepository.saveAndFlush(newWorkExperience);
    }


    @PatchMapping("/{workexperience_id}")
    public WorkExperience update(@RequestParam("position") Optional<String> position,
                            @RequestParam("date_from") Optional<String> date_from,
                            @RequestParam("date_to") Optional<String> date_to,
                            @RequestParam("details") Optional<String> details,
                            @RequestParam("institution_id") Optional<String> institution_id,
                            @PathVariable Integer workexperience_id) {
        WorkExperience workExperienceToUpdate = workExperienceRepository.getById(workexperience_id);
        position.ifPresent(workExperienceToUpdate::setPosition);
        date_from.ifPresent(datefrom -> workExperienceToUpdate.setDate_from(java.sql.Date.valueOf(datefrom)));
        date_to.ifPresent(dateto -> workExperienceToUpdate.setDate_to(java.sql.Date.valueOf(dateto)));
        details.ifPresent(workExperienceToUpdate::setDetails);
        institution_id.ifPresent(id -> {
            Institution updatedInstitution = institutionRepository.findByInstitution_id(valueOf(id));
            workExperienceToUpdate.setInstitution(updatedInstitution);
        });
        return workExperienceRepository.saveAndFlush(workExperienceToUpdate);
    }

    @RequestMapping(value = "{workexperience_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer workexperience_id) {
        workExperienceRepository.deleteById(workexperience_id);
    }
}
