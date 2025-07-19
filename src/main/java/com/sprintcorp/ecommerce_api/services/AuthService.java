package com.sprintcorp.ecommerce_api.services;

import com.sprintcorp.ecommerce_api.dtos.*;
import com.sprintcorp.ecommerce_api.entities.User;
import com.sprintcorp.ecommerce_api.repositories.AuthRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User createUser(UserRegisterDTO userRegisterDTO) {
        if (authRepository.findByEmail(userRegisterDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = new User();
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getLastName());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setRole(userRegisterDTO.getRole().name());

        return authRepository.save(user);
    }

    public Map<String, String> loginUser(LoginDTO loginDTO) {
        User user = authRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

    public User userProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return authRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public String updatePassword(PasswordUpdateDTO  passwordUpdateDTO) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = authRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(passwordUpdateDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        if (!passwordUpdateDTO.getNewPassword().equals(passwordUpdateDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("New password and confirm password do not match");
        }

        user.setPassword(passwordEncoder.encode(passwordUpdateDTO.getNewPassword()));
        authRepository.save(user);

        return "Password updated successfully";
    }

    public User updateProfile(ProfileUpdateDTO profileUpdateDTO) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = authRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(profileUpdateDTO.getFirstName());
        user.setLastName(profileUpdateDTO.getLastName());

        return authRepository.save(user);
//        return updated;
    }
}
