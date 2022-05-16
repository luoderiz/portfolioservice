package com.myservice.portfolioservice.controllers;

import com.myservice.portfolioservice.dto.UserLoginResponse;
import com.myservice.portfolioservice.models.Person;

import com.myservice.portfolioservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.server.ResponseStatusException;

import static com.myservice.portfolioservice.security.JWTAuthorizationFilter.SECRET;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginRegistrationController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public UserLoginResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Person requestLoginPerson = personRepository.findByUsername(username);
        if (requestLoginPerson == null ) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "El usuario o la contraseña son incorrectos.");
        }
        String encodedPassword = requestLoginPerson.getPassword();
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "El usuario o la contraseña son incorrectos.");
        }
        String token = getJWTToken(username);
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setUsername(username);
        userLoginResponse.setToken(token);
        return userLoginResponse;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("mail") String mail) {
        if (personRepository.findByUsername(username) != null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ya existe.");
        }
        Person person = new Person();
        person.setUsername(username);
        person.setName(name);
        person.setSurname(surname);
        person.setMail(mail);
        person.setPassword(passwordEncoder.encode(password));
        personRepository.saveAndFlush(person);
    }

    private String getJWTToken(String username) {
        String secretKey = System.getenv(SECRET);
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