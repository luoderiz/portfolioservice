package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
