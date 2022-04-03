package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftSkillRepository extends JpaRepository<SoftSkill, Integer> {
}
