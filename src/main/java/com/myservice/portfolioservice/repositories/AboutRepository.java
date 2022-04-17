package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.About;
import com.myservice.portfolioservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface AboutRepository extends JpaRepository<About, Integer> {
}
