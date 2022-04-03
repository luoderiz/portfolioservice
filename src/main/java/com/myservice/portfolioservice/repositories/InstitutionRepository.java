package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
}
