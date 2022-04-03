package com.myservice.portfolioservice.models;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "workexperience")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String position;
    private Date date_from;
    private Date date_to;
    private String details;
    private Integer institution_id;
    private Integer person_id;

    public WorkExperience() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

   public Integer getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(Integer institution_id) {
        this.institution_id = institution_id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
