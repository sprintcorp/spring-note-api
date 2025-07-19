package com.sprintcorp.ecommerce_api.controllers;

import com.sprintcorp.ecommerce_api.dtos.*;
import com.sprintcorp.ecommerce_api.entities.User;
import com.sprintcorp.ecommerce_api.mappers.UserMapper;
import com.sprintcorp.ecommerce_api.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public final class AuthController {

    public AuthService authService;
    private final UserMapper userMapper;

    @PostMapping("register")
    public UserResponseDTO createUser(@RequestBody @Valid UserRegisterDTO userDTO){
        User response = authService.createUser(userDTO);
        return userMapper.userDTO(response);
    }

    @PostMapping("login")
    public Map<String, String> login(@RequestBody @Valid LoginDTO loginDTO){
        return authService.loginUser(loginDTO);
    }

    @GetMapping("profile")
    public UserResponseDTO getUser(){
        return userMapper.userDTO(authService.userProfile());
    }

    @PatchMapping("password-update")
    public String updatePassword(@RequestBody @Valid PasswordUpdateDTO passwordUpdateDTO){
        return authService.updatePassword(passwordUpdateDTO);
    }

    @PatchMapping("profile-update")
    public UserResponseDTO updateProfile(@RequestBody @Valid ProfileUpdateDTO profileUpdateDTO){
        return userMapper.userDTO(authService.updateProfile(profileUpdateDTO));
    }
}
