package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
