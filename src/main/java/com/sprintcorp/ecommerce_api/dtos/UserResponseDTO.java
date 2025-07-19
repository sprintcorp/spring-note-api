package com.sprintcorp.ecommerce_api.dtos;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
