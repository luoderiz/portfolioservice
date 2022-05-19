package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select  t from city t where t.city_id=?1")
    City findByCity_Id(Integer city_id);
}