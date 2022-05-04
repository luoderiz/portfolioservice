package com.myservice.portfolioservice.controllers;
import com.myservice.portfolioservice.dto.UserRegistration;
import com.myservice.portfolioservice.models.User;
import com.myservice.portfolioservice.models.UserDto;

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
@RequestMapping("/api/user")
public class UserDtoController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public UserDto login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = getJWTToken(username);
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setToken(token);
        return userDto;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegistration register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userRegistration;
    }

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