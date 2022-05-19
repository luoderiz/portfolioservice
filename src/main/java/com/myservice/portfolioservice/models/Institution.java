package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer institution_id;

    @NotBlank(message = "Institution should not be null or blank")
    @Size(min = 2, max = 90, message = "Institution must be between 2 and 90 characters")
    private String institution;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Institution() {
    }

    public Integer getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(Integer id) {
        this.institution_id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
