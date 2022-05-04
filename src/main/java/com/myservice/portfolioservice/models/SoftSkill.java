package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "softskill")
public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer softskill_id;

    @NotBlank(message = "Skill should not be null or blank")
    @Size(min = 3, max = 1020, message = "Skill must be between 3 and 1020 characters")
    private String skill;

    private Integer person_id;

    public SoftSkill() {
    }

    public Integer getSoftskill_id() {
        return softskill_id;
    }

    public void setSoftskill_id(Integer id) {
        this.softskill_id = id;
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
