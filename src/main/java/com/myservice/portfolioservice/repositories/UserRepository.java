package com.myservice.portfolioservice.repositories;

import com.myservice.portfolioservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
