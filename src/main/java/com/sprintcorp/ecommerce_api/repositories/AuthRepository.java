package com.sprintcorp.ecommerce_api.repositories;

import com.sprintcorp.ecommerce_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
