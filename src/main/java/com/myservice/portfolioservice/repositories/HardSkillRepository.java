package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HardSkillRepository extends JpaRepository<HardSkill, Integer> {
    @Query("select  t from hardskill t where t.person_id=?1")
    List<HardSkill> findByPerson_id(Integer id);
}