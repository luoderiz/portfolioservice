package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @Email
    private String mail;

    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
    private String username;

    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    public Person() {
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
}
