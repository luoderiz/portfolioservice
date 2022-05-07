package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer institution_id;

    @NotBlank(message = "Name should not be null or blank")
    @Size(min = 2, max = 90, message = "Institution must be between 2 and 90 characters")
    private String name;

    @NotBlank(message = "City should not be null or blank")
    @Size(min = 2, max = 60, message = "City must be between 2 and 60 characters")
    private String city;


    public Institution() {
    }

    public Integer getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(Integer id) {
        this.institution_id = id;
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
