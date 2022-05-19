package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.util.List;

@Entity(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer education_id;

    @NotBlank(message = "Degree should not be null or blank")
    @Size(min = 10, max = 90, message = "Degree must be between 10 and 90 characters")
    private String degree;

    @Past(message = "Date should be a valid past date")
    private Date date_from;

    @Past(message = "Date should be a valid past date")
    private Date date_to;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    private Integer person_id;


    public Education() {
    }

    public Integer getEducation_id() {
        return education_id;
    }

    public void setEducation_id(Integer education_id) {
        this.education_id = education_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }


    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
