package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "about")
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer about_id;

    @NotBlank(message = "About should not be null or blank")
    @Size(min = 3, max = 1020, message = "About must be between 3 and 1020 characters")
    private String about;

    private Integer person_id;

    public About() {
    }

    public Integer getAbout_id() {
        return about_id;
    }

    public void setAbout_id(Integer about_id) {
        this.about_id = about_id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
