package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
