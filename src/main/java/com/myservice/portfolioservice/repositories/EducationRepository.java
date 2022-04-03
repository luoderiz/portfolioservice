package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer> {
}
