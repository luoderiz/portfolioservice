package com.myservice.portfolioservice.models;

import javax.persistence.*;

@Entity(name = "hardskill")
public class HardSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hardskill;
    private Integer person_id;

    public HardSkill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHardskill() {
        return hardskill;
    }

    public void setHardskill(String hardskill) {
        this.hardskill = hardskill;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

}
