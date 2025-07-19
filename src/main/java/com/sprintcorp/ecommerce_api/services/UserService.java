package com.sprintcorp.ecommerce_api.services;

import com.sprintcorp.ecommerce_api.entities.User;
import com.sprintcorp.ecommerce_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
