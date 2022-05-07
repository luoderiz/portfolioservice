package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoftSkillRepository extends JpaRepository<SoftSkill, Integer> {
    @Query("select t from softskill t where t.person_id=?1")
    List<SoftSkill> findByPerson_id(Integer id);
}
