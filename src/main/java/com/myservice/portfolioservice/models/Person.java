package com.myservice.portfolioservice.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name should not be null or blank")
    @Size(min = 1, max = 60, message = "Name must be between 1 and 60 characters")
    private String name;

    @NotBlank(message = "Surname should not be null or blank")
    @Size(min = 1, max = 60, message = "Surname must be between 1 and 60 characters")
    private String surname;

    @Size(min = 1, max = 45, message = "Git must be between 1 and 45 characters")
    private String git;

    @Size(min = 10, max = 14, message = "Tel must be between 10 and 14 characters")
    private Integer tel;

    @Email(message = "Email should be valid")
    private String mail;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<About> about;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SoftSkill> softskill;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HardSkill> hardskill;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> education;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL, orphanRemoval = true)
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
