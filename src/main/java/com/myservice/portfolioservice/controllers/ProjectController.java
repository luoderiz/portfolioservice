package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.Project;
import com.myservice.portfolioservice.repositories.PersonRepository;
import com.myservice.portfolioservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user/{username}/project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PersonRepository personRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping
    public List<Project> getAllProject(@PathVariable String username) {
        Person person = personRepository.findByUsername(username);
        Integer id = person.getId();
        return projectRepository.findByPerson_id(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@PathVariable String username,
                          @RequestParam("name") String name,
                          @RequestParam("details") String details,
                          @RequestParam("url") String url) {
        Person person = personRepository.findByUsername(username);
        Integer personId = person.getId();
        Project newProject = new Project();
        newProject.setPerson_id(personId);
        newProject.setName(name);
        newProject.setDetails(details);
        newProject.setUrl(url);
        return projectRepository.saveAndFlush(newProject);
    }

    @PatchMapping("/{project_id}")
    public Project update(@RequestParam(name="name") Optional<String> name,
                          @RequestParam(name="details") Optional<String> details,
                          @RequestParam(name="url") Optional<String> url,
                          @PathVariable Integer project_id) {
        Project projectToUpdate = projectRepository.getById(project_id);
        name.ifPresent(projectToUpdate::setName);
        details.ifPresent(projectToUpdate::setDetails);
        url.ifPresent(projectToUpdate::setUrl);
        return projectRepository.saveAndFlush(projectToUpdate);
    }

    @RequestMapping(value = "/{project_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer project_id) {
        projectRepository.deleteById(project_id);
    }

}
