package com.myservice.portfolioservice.controllers;
import com.myservice.portfolioservice.dto.UserLogin;
import com.myservice.portfolioservice.models.Person;
import com.myservice.portfolioservice.models.User;

import com.myservice.portfolioservice.repositories.PersonRepository;
import com.myservice.portfolioservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginRegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/login")
    public UserLogin login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = getJWTToken(username);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setToken(token);
        return userLogin;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person = personRepository.saveAndFlush(person);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPerson_id(person.getId());
        userRepository.saveAndFlush(user);
    }

    //todo: secretkey
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts
                .builder()
                .setId("PortfolioJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (30*60*1000)))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}