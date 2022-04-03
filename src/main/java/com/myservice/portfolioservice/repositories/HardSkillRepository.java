package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardSkillRepository extends JpaRepository<HardSkill, Integer> {
}
