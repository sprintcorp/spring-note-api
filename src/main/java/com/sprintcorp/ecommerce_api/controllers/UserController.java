package com.sprintcorp.ecommerce_api.controllers;

import com.sprintcorp.ecommerce_api.dtos.UserRegisterDTO;
import com.sprintcorp.ecommerce_api.entities.User;
import com.sprintcorp.ecommerce_api.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public final class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public String createUser(){
        return "user created";
    }
}
