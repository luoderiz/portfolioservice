package com.myservice.portfolioservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;

    @NotBlank(message = "Project name should not be null or blank")
    @Size(min = 1, max = 60, message = "Project name must be between 3 and 60 characters")
    private String name;

    @Size(min = 1, max = 500, message = "Project url must be between 3 and 500 characters")
    private String url;

    @Size(min = 1, max = 1020, message = "Project details must be between 3 and 1020 characters")
    private String details;

    private Integer person_id;

    public Project() {
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer id) {
        this.project_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
