package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "softskill")
public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skill_id;

    public Integer getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(Integer skill_id) {
        this.skill_id = skill_id;
    }

    @NotBlank(message = "Skill should not be null or blank")
    @Size(min = 3, max = 1020, message = "Skill must be between 3 and 1020 characters")
    private String skill;

    private Integer person_id;

    public SoftSkill() {
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String softskill) {
        this.skill = softskill;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
