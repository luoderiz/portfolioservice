package com.myservice.portfolioservice.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name should not be null or blank")
    @Size(max = 60, message = "Name shouldn't be longer than 60 characters")
    private String name;

    @NotBlank(message = "Surname should not be null or blank")
    @Size(max = 60, message = "Surname shouldn't be longer than 60 characters")
    private String surname;

    @Size(max = 45, message = "Git shouldn't be longer than 45 characters")
    private String git;

    @NotBlank(message = "Mail should not be null or blank")
    @Email
    @Size(max = 90, message = "Mail shouldn't be longer than 90 characters")

    private String mail;

    @Size(max = 45, message = "Linkedin shouldn't be longer than 45 characters")
    private String linkedin;

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @NotBlank(message = "Username should not be null or blank")
    @Size(min = 4, max = 10, message = "Username shouldn't be longer than 10 characters")
    private String username;

    @NotBlank(message = "Password should not be null or blank")
    @Size(min = 8, max = 60, message = "Password must be between 8 and 20 characters")
    private String password;

    public Person() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
