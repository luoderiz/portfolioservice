package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {
    @Query("select t from workexperience t where t.person_id=?1")
    List<WorkExperience> findByPerson_id(Integer id);
}
