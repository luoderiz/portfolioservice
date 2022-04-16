package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name should not be null or blank")
    @Size(min = 2, max = 90, message = "Institution must be between 2 and 90 characters")
    private String name;

    @NotBlank(message = "City should not be null or blank")
    @Size(min = 2, max = 60, message = "City must be between 2 and 60 characters")
    private String city;

    @OneToMany(mappedBy = "institution_id")
    private List<WorkExperience> workexperience;

    @OneToMany(mappedBy = "institution_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> education;

    public Institution() {
    }

    public List<WorkExperience> getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(List<WorkExperience> workexperience) {
        this.workexperience = workexperience;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
