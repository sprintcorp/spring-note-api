package com.sprintcorp.ecommerce_api.repositories;

import com.sprintcorp.ecommerce_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
