package com.myservice.portfolioservice.controllers;
import com.myservice.portfolioservice.models.UserDto;

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
@RequestMapping("/api/login")
public class UserDtoController {

    @PostMapping
    public UserDto login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = getJWTToken(username);
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setToken(token);
        return userDto;
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