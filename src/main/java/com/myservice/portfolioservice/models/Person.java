package com.myservice.portfolioservice.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String git;
    private Integer tel;
    private String mail;

    @OneToMany(mappedBy = "person_id")
    private List<About> about;

    @OneToMany(mappedBy = "person_id")
    private List<SoftSkill> softskill;

    @OneToMany(mappedBy = "person_id")
    private List<HardSkill> hardskill;

    @OneToMany(mappedBy = "person_id")
    private List<Education> education;

    @OneToMany(mappedBy = "person_id")
    private List<WorkExperience> workexperience;

    public Person() {
    }

    public List<About> getAbout() {
        return about;
    }

    public void setAbout(List<About> about) {
        this.about = about;
    }

    public List<SoftSkill> getSoftskill() {
        return softskill;
    }

    public void setSoftskill(List<SoftSkill> softskill) {
        this.softskill = softskill;
    }

    public List<HardSkill> getHardskill() {
        return hardskill;
    }

    public void setHardskill(List<HardSkill> hardskill) {
        this.hardskill = hardskill;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<WorkExperience> getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(List<WorkExperience> workexperience) {
        this.workexperience = workexperience;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
