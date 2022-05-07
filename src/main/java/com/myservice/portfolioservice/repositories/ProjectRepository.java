package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("select  t from project t where t.person_id=?1")
    List<Project> findByPerson_id(Integer id);
}