package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "hardskill")
public class HardSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skill_id;

    @NotBlank(message = "Skill should not be null or blank")
    @Size(max = 1020, message = "Skill shouldn't be longer than 1020 characters")
    private String skill;

    private Integer person_id;

    public HardSkill() {
    }

    public Integer getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(Integer skill_id) {
        this.skill_id = skill_id;
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
