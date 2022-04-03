package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {
}
