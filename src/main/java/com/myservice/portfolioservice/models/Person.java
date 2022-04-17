package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
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

    @Digits(message = "Telephone should be valid", integer = 13, fraction = 0)
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

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    public Person() {
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProjects(Project project){
        this.projects.add(project);
    }

    public List<About> getAbout() {
        return about;
    }

    public void setAbout(List<About> about) {
        this.about = about;
    }

    public void addAbout(About about) {
        this.about.add(about);
    }

    public List<SoftSkill> getSoftskill() {
        return softskill;
    }

    public void addSoftskill(SoftSkill softSkill) {
        this.softskill.add(softSkill);
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

    public void addHardskill(HardSkill hardSkill) {
        this.hardskill.add(hardSkill);
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public void addEducation(Education education) {
        this.education.add(education);
    }

    public List<WorkExperience> getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(List<WorkExperience> workexperience) {
        this.workexperience = workexperience;
    }

    public  void addWorkexperience(WorkExperience workExperience){
        this.workexperience.add(workExperience);
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
