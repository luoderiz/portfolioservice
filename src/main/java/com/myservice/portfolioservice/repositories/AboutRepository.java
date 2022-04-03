package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Integer> {
}
