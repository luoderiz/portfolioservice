package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Education;
import com.myservice.portfolioservice.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
    @Query("select t from institution t where t.institution_id=?1")
    Institution findByInstitution_id(Integer id);
}
