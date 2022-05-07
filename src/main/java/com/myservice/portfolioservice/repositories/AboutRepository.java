package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AboutRepository extends JpaRepository<About, Integer> {
    @Query("select t from about t where t.person_id=?1")
    List<About> findByPerson_id(Integer id);
}