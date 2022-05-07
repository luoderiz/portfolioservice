package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    @Query("select t from education t where t.person_id=?1")
    List<Education> findByPerson_id(Integer id);
}