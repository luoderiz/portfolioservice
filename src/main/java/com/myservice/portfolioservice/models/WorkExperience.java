package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity(name = "workexperience")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workexperience_id;

    @NotBlank(message = "Position should not be null or blank")
    @Size(min = 3, max = 1020, message = "Position must be between 3 and 1020 characters")
    private String position;

    @Past(message = "Date should be a valid past date")
    private Date date_from;

    @Past(message = "Date should be a valid past date")
    private Date date_to;

    @Size(min = 10, max = 255, message = "Details must be between 10 and 255 characters")
    private String details;

    private Integer person_id;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    public WorkExperience() {
    }

    public Integer getWorkexperience_id() {
        return workexperience_id;
    }

    public void setWorkexperience_id(Integer id) {
        this.workexperience_id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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


    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
