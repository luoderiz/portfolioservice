package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "hardskill")
public class HardSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hardskill_id;

    @NotBlank(message = "Skill should not be null or blank")
    @Size(min = 3, max = 1020, message = "Skill must be between 3 and 1020 characters")
    private String skill;

    private Integer person_id;

    public HardSkill() {
    }

    public Integer getHardskill_id() {
        return hardskill_id;
    }

    public void setHardskill_id(Integer id) {
        this.hardskill_id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String hardskill) {
        this.skill = hardskill;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

}
